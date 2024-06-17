$(document).ready(function(){
    
    var nopinjaman, angsurke, tglangsur, besarangsur, sisapinjaman, nokaryawan, namakaryawan, noanggota, namaanggota, page;
    
    $('#sidebarBuka').click( function() {
        $('#sidebar').toggleClass('active');
        console.log("slide-slide");
    });
    
    $('#backHome').click(function(){
       window.history.back(); 
    });
    
    function getInputValue(){
        nopinjaman = $('#nopinjaman').val();
        tglangsur = $('#tglangsur').val();
        noanggota = $('#noanggota').val();
        namaanggota = $('#namaanggota').val();
        angsurke = $('#angsuranke').val();
        sisapinjaman = $('#sisapinjaman').val();
        besarangsur = $('#besarangsur').val();
        nokaryawan = $('#petugas').val();
        namakaryawan = $('#namapetugas').val();
    }
    
    $('#btnAdd').click(function(){
        $('#myModal').fadeIn();
        page="tambah";
    });
    $('#btnBatal').click(function(){
        $('#myModal').fadeOut();
        $('#nopinjaman').val("");
        $('#tglangsur').val("");
        $('#noanggota').val("");
        $('#namaanggota').val("");
        $('#angsuranke').val("");
        $('#sisapinjaman').val("");
        $('#besarangsur').val("");
        $('#petugas').val("");
        $('#namapetugas').val("");
       
    });
    
    $.ajax({
        url: '/Koperasi//angsuranCtr',
        method: 'GET',
        dataType: "json",
        success:
                function(data){
                    $('#tabelangsuran').dataTable({
                        serverside: true,
                        processing: true,
                        data: data,
                        sort: true,
                        searching: true,
                        paging: true,  
                        columns: [
                            {'data': 'nopinjaman','name':'nopinjaman','type':'string'},
                            {'data': 'angsuranke'},
                            {'data': 'noanggota'},
                            {'data': 'namaanggota'},
                            {'data': 'besarangsur'},
                            {'data': 'sisapinjaman'},
                            {'data': 'namakaryawan'},
                            {'data': null, 'className': 'dt-right',
                                'mRender': function(o){
                                   return "<a class='btn btn-outline-success btn-sm'"
                                   +"id='btnEdit'>Edit</a>"
                                   +"&nbsp;&nbsp;"
                                   +"<a class='btn btn-outline-danger btn-sm'"
                                   +"id='btnDel'>Delete</a>"
                               }
                            }
                        ]
                    })
                }
    });
    
    $("#tabelangsuran tbody").on('click', '#btnDel', function(){
        var baris = $(this).closest('tr');
        var nopinjaman = baris.find("td:eq(0)").text();
        page="hapus";
        
        $.confirm({
            title: 'Warning!',
            content: 'Apakah anda yakin ingin menghapus No Pinjaman '+nopinjaman+" ?",
            buttons: {
                yes: {
                    btnClass: 'btn-red',
                    action: function(data, status){
                                $.post('/Koperasi/angsuranCtr', {
                                    page: page,
                                    nopinjaman: nopinjaman
                                },
                                function(data, status){
                                   if(data === "Data Berhasil di Hapus"){ 
                                   $.alert({
                                        title: 'Berhasil!',
                                        content: data,
                                        buttons: {
                                            ok: {
                                                btnClass: 'btn-red',
                                                action: function(){
                                                    location.reload();
                                                }
                                            }
                                        }
                                    }) 
                                }
                            }
                                    
                        )
                    }
                },
                No:{
                    btnClass: 'blue',
                    action: function(){
                        
                    }
                }
            }
        })
    });
    
    $('#lookuppinjaman').click(function(){
       $('#lookupmodalPinjaman').fadeIn();
       $.ajax({
           url: '/Koperasi/pinjamanCtr',
           page: page,
           method: "GET",
           dataType: "json",
           success:
                   function(data){
                       $('#tabellookupPinjaman').dataTable({
                            serverside: true,
                            processing: true,
                            data: data,
                            sort: false,
                            searching: true,
                            paging: true,
                            columns: [
                                {'data': 'nopinjaman','name':'nopinjaman','type':'string'},
                                {'data': 'noanggota'},
                                {'data': 'namaAnggota'},
                                {'data': null, 'className': 'dt-right',
                                    'mRender': function(o){
                                        return "<a class='btn btn-outline-success btn-sm'"
                                        +"id='btnPilih'>Pilih</a>";
                                    }
                                }
                            ]
                       })
                   }
       })
    });
    
    $('#tabellookupPinjaman tbody').on('click','#btnPilih', function(){
       $('#lookupmodalPinjaman').fadeOut();
       page="rupiah";
       var baris = $(this).closest('tr');
       var nopinjaman = baris.find('td:eq(0)').text();
       $.post('/Koperasi/angsuranCtr', {
           page: page,
           nopinjaman: nopinjaman
       },
            function(data, status){
                console.log(data);
                getAnggota();
                var res = data.length-1;
                $('#nopinjaman').val(data[res].nopinjaman);
                $('#noanggota').val(data[res].noanggota);
                $('#namaanggota').val(data[res].namaanggota);
                var angsuranpokok = data[res].angsuranpokok;
                var angsuranbunga = data[res].angsuranbunga;
                var angsurkek = data[res].angsuranke;
                $('#angsuranke').val(parseFloat(angsurkek)+1);
                besarangsur = parseFloat(angsuranpokok) + parseFloat(angsuranbunga);
                $('#besarangsur').val(besarangsur);
                getRupiah();
                rupiah();
                findAngsur();
                
                
                
            }
        )
    });
    
   
    
    function cekId(){
        $('#lookupmodal').fadeOut();
            console.log("kepilih");
            page='tampil';  
            var nik = $('#nopinjaman').val();
            $.post('/Koperasi/angsuranCtr', {
                page: page,
                nik:nik
            },
                 function(data, status){
                     console.log(data);
                 }
             );
    }
    
    $('#nopinjaman').keyup(function(){
        page="rupiah";
        var nopinjaman = $('#nopinjaman').val();
        $.post('/Koperasi/angsuranCtr', {
            page: page,
            nopinjaman: nopinjaman
        },
             function(data, status){
                 var res = data.length-1;
                 console.log(data[res].angsuranke);
                 $('#noanggota').val(data[res].noanggota);
                 $('#namaanggota').val(data[res].namaanggota);
                 var angsuranpokok = data[res].angsuranpokok;
                 var angsuranbunga = data[res].angsuranbunga;
                 var angsurkek = data[res].angsuranke;
                 $('#angsuranke').val(parseFloat(angsurkek)+1);
                 besarangsur = parseFloat(angsuranpokok) + parseFloat(angsuranbunga);
                 $('#besarangsur').val(besarangsur);
                 getRupiah();
                 rupiah();
                 findAngsur();
                 
             }
         )
    });
    
    $('#nopinjaman').keydown(function(){
        $('#noanggota').val("");
        $('#namaanggota').val("");
        $('#angsuranke').val("");
        $('#sisapinjaman').val("");
        $('#besarangsur').val("");
        $('#namapetugas').val("");
        $('#formatsisapinjaman').val("");
        $('#formatbesarangsur').val("");
    });
    
    
    function rupiah(){
        var number = new Intl.NumberFormat("de-DE", {
            style: "currency",
            currency: "IDR"
        })
        sisapinjaman = $('#sisapinjaman').val();
        besarangsur = $('#besarangsur').val();
        
        $('#formatsisapinjaman').val("Rp. "+number.format(sisapinjaman));
        $('#formatbesarangsur').val("Rp. "+number.format(besarangsur));
    }
    
    
    $('#lookuppetugas').click(function(){
       $('#lookupmodal').fadeIn();
       $.ajax({
           url: '/Koperasi/karyawanCtr',
           page: page,
           method: "GET",
           dataType: "json",
           success:
                   function(data){
                       $('#tabellookup').dataTable({
                            serverside: true,
                            processing: true,
                            data: data,
                            sort: false,
                            searching: true,
                            paging: true,
                            columns: [
                                {'data': 'nik','name':'nik','type':'string'},
                                {'data': 'nama'},
                                {'data': null, 'className': 'dt-right',
                                    'mRender': function(o){
                                        return "<a class='btn btn-outline-success btn-sm'"
                                        +"id='btnPilih'>Pilih</a>";
                                    }
                                }
                            ]
                       })
                   }
       })
    });
    
    $('#tabellookup tbody').on('click','#btnPilih', function(){
       $('#lookupmodal').fadeOut();
       page="tampil";
       var baris = $(this).closest('tr');
       var nik = baris.find('td:eq(0)').text();
       $.post('/Koperasi/karyawanCtr', {
           page: page,
           nik: nik
       },
            function(data, status){
                $('#petugas').val(data.nik);
                $('#namapetugas').val(data.nama);
            }
        )
    });
    
    $('#petugas').keyup(function(){
        page="tampil";
        var nik = $('#petugas').val();
        $.post('/Koperasi/karyawanCtr', {
            page: page,
            nik: nik
        },
             function(data, status){
                 $('#namapetugas').val(data.nama);
             }
         )
    });
    
    $('#noanggota').ready(function(){
        page="tampil";
    });
    
    $('#btnBackPinjaman, #btnBackLookup').click(function(){
        $('#lookupmodalPinjaman').fadeOut();
        $('#lookupmodal').fadeOut();
    });
    
    function getRupiah(){
        var nopinjaman = $('#nopinjaman').val();
        page="rupiah";
        $.post('/Koperasi/angsuranCtr', {
            page: page,
            nopinjaman: nopinjaman
        },
            function(data, status){
                var res = data.length-1;
                var pokokpinjaman = data[res].pokokpinjaman;
                var bungapinjaman = data[res].bungapinjaman;
                angsurke = data[res].angsuranke;
                besarangsur = data[res].besarangsur;

                sisapinjaman = ( parseFloat(pokokpinjaman) + parseFloat(bungapinjaman) ) - ( parseFloat(angsurke) * parseFloat(besarangsur) );
                $('#sisapinjaman').val(sisapinjaman);
                rupiah();
                
            }
        )
    }
    
    $('#tabelangsuran tbody').on('click','#btnEdit', function(){
        page="rupiah";
        var baris = $(this).closest('tr');
        var nopinjaman = baris.find('td:eq(0)').text();
        $.post('/Koperasi/angsuranCtr', {
            page: page,
            nopinjaman: nopinjaman
        },
             function(data, status){
                 
                 var res = data.length-1;
                 console.log(data[res]);
                 console.log(data.nopinjaman);
                 if(data > 2){
                     console.log("GaBisa");
                 }else{
                     console.log("bisa");
                 }                
             }
         )
        
    });
    
    $('#btnSave').click(function(){
        console.log(page);
        page="tambah";
        getInputValue();
        if(nopinjaman === ""){
            $('#nopinjaman').css('border-color','red');
            $('#nopinjaman').keyup(function(){
                $('#nopinjaman').css('border-color','lightgrey');
            })
            $.alert({
                icon: 'fa fa-warning',
               title: 'Gagal!',
               content: 'Nomor Pinjaman Harus diisi!',
               buttons: {
                   ok: {
                       btnClass: 'btn-red',
                       action: function(){
                           $("#noanggota").focus();
                           $("#noanggota").keypress(function(){
                                $("#noanggota").css("border-color","black")
                           })
                       }
                   }
               }
            })
        }else{
            $.post('/Koperasi/angsuranCtr', {
                page: page,
                nopinjaman: nopinjaman,
                angsurke: angsurke,
                tglangsur: tglangsur,
                besarangsur: besarangsur,
                sisapinjaman: sisapinjaman,
                nokaryawan: nokaryawan
            },
                function(data, status){
                    if(data === "Data berhasil disimpan, OK..."){
                        $.alert({
                            icon : 'fas fa-check-circle',
                            title: 'Berhasil',
                            type: 'blue',
                            content: data,
                            typeAnimated: true,
                            buttons: {
                                ok: {
                                    btnClass: 'btn-red',
                                    action: function(){
                                        location.reload();   
                                    }  
                                }          
                            }
                        });
                    }
                }
            )
        }
    })
    
    function findAngsur(){
        var nopinjaman = $('#nopinjaman').val();
        page="rupiah";
        $.post('/Koperasi/angsuranCtr', {
            page: page,
            nopinjaman: nopinjaman
        },
            function(data, status){
                console.log(data);
            }
        )
        
    }
    
    
    
    
    
    
})

