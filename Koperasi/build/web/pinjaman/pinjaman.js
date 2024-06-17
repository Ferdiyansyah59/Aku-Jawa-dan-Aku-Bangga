$(document).ready(function(){
    
    var nopinjaman, noanggota, tglpinjaman, pokokpinjaman, bungapinjaman, lamapinjaman, angsuranpokok, angsuranbunga, accpetugas, page, persenbunga;
    
    $('#lookuppetugas').click(function(){
        $('#lookupmodal').fadeIn(); 
        $('#header1').html("No Karyawan");
        $('#header2').html("Nama Karyawan");
        page = "lookuppetugas";
        $.ajax({
            url: '/Koperasi/karyawanCtr',
            method: 'GET',
            dataType: 'json',
            success:
                    function(dat){
                        $('#tabellookup').dataTable({
                            serverside: true,
                            processing: true,
                            data: dat,
                            sort: false,
                            searching: true,
                            paging: true,
                            columns:[
                                {'data': 'nik', 'name':'nik','type':'string'},
                                {'data': 'nama'},
                                {'data': null, 'className': 'dt-right',
                                    'mRender': function(o){
                                        return "<a class='btn btn-outline-success btn-sm'"
                                        +"id='btnPilih'>Pilih</a>";
                                    }
                                }
                            ]
                        });
                        console.log("Datanya adalah ", dat);
                    }
        })  
    });
    
    $('#tabellookup tbody').on('click','#btnPilih', function(){
            $('#lookupmodal').fadeOut();
            console.log("kepilih");
            page='tampil';
            var baris = $(this).closest('tr');
            var nik = baris.find('td:eq(0)').text();
            $.post('/Koperasi/karyawanCtr', {
                page: page,
                nik:nik
            },
                 function(data, status){
                     $('#accpetugas').val(data.nik);
                     $('#namapetugas').val(data.nama);
                 }
             );
        });
        
        
        $('#lookupnoanggota').click(function(){
           $('#lookupmodalAnggota').fadeIn();
           $('#header1').html("Nomor Anggota");
           $("#header2").html("Nama Anggota");
           page = "lookupanggota";
        $.ajax({
            url: '/Koperasi/anggotaCtr',
            method: 'GET',
            dataType: 'json',
            success:
                    function(dat){
                        $('#tabellookupAnggota').dataTable({
                            serverside: true,
                            processing: true,
                            data: dat,
                            sort: false,
                            searching: true,
                            paging: true,
                            columns:[
                                {'data': 'noanggota', 'name':'noanggota','type':'string'},
                                {'data': 'nama'},
                                {'data': null, 'className': 'dt-right',
                                    'mRender': function(o){
                                        return "<a class='btn btn-outline-success btn-sm'"
                                        +"id='btnPilihAnggota'>Pilih</a>";
                                    }
                                }
                            ]
                        });
                        console.log("Datanya adalah ", dat);
                    }
            })  
        });
        
        $('#tabellookupAnggota tbody').on('click','#btnPilihAnggota', function(){
            $('#lookupmodalAnggota').fadeOut();
            console.log("kepilih Anggota");
            page='tampil';
            var baris = $(this).closest('tr');
            var noanggotaa = baris.find('td:eq(0)').text();
            $.post('/Koperasi/anggotaCtr', {
                page: page, 
                noanggota: noanggotaa
            },
                 function(data, status){
                     console.log(data)
                     $('#noanggota').val(data.noanggota);
                     $('#namaanggota').val(data.nama);
                 }
             );
        });
    
    
    $('#btnBackLookup').click(function(){
        $('#lookupmodal').fadeOut();
    });
    
    $('#btnBackAnggota').click(function(){
        $('#lookupmodalAnggota').fadeOut();
    });
    
    
    $('#lamapinjaman, #pokokpinjaman, #persen').keyup(function(){
        lamapinjaman = $('#lamapinjaman').val();
        pokokpinjaman = $('#pokokpinjaman').val();
        persenbunga = $('#persen').val();
        
        var number = new Intl.NumberFormat("de-DE", {
            style:"currency",
            currency: "IDR"
        })
        
        
        bungapinjaman = (parseFloat(lamapinjaman)/12) * (parseFloat(pokokpinjaman)) * (parseFloat(persenbunga)/100);
        $('#bungapinjaman').val(bungapinjaman.toFixed(2));
        $('#formatbungapinjam').val("Rp. "+number.format(bungapinjaman));
        
        angsuranpokok = Number(pokokpinjaman) / lamapinjaman;
        $('#angsuranpokok').val(Math.ceil(angsuranpokok));
        $('#formatangsuranpokok').val("Rp. "+number.format(Math.ceil(angsuranpokok)));
        
        angsuranbunga = bungapinjaman/lamapinjaman;
        $('#angsuranbunga').val(Math.ceil(angsuranbunga).toFixed(2));
        $('#formatangsuranbunga').val("Rp. "+number.format(Math.ceil(angsuranbunga)));
        
    });
    
    $('#lamapinjaman, #pokokpinjaman, #persen').keydown(function(){
        $('#bungapinjaman').val("");
        $('#formatbungapinjam').val("");

        $('#angsuranpokok').val("");
        $('#formatangsuranpokok').val("");
        
        $('#angsuranbunga').val("");
        $('#formatangsuranbunga').val("");
        
    });
    
    $('#pokokpinjaman').focusout(function(){
        pokokpinjaman = $('#pokokpinjaman').val();
        
        var number = new Intl.NumberFormat("de-DE", {
            style:"currency",
            currency: "IDR"
        })
        $('#formatpokokpinjam').val("Rp. "+number.format(pokokpinjaman));
    });
    
    $('#pokokpinjaman').focusin(function(){
        $('#formatpokokpinjam').val("");
    });
    
    $('#sidebarBuka').click( function() {
        $('#sidebar').toggleClass('active');
        console.log("slide-slide");
    });
    
    $('#backHome').click(function(){
      window.history.back(); 
   });
    
    $('#noanggota').keyup(function(){
        page="tampil";
        var noanggota = $('#noanggota').val();
        $.post('/Koperasi/anggotaCtr', {
            page: page,
            noanggota: noanggota
        },
            function(data, status){
                $('#namaanggota').val(data.nama);
            }
        )
    });
    
    $('#accpetugas').keyup(function(){
       page="tampil";
       var nik = $('#accpetugas').val();
       $.post('/Koperasi/karyawanCtr', {
           page: page,
           nik: nik
       },
            function(data, status){
                $('#namapetugas').val(data.nama);
            }
       )
    });
    
    
    
    
    $.ajax({
        url: '/Koperasi/pinjamanCtr',
        method: 'GET',
        dataType: "json",
        success:
                function(data){
                    $("#tabelpinjaman").dataTable({
                        serverside: true,
                        processing: true,
                        data: data,
                        sort: true,
                        searching: true,
                        paging: true,
                        columns: [
                            {'data': 'nopinjaman','name':'nopinjaman','type':'string'},
                            {'data': 'noanggota'},
                            {'data': 'namaAnggota'},
                            {'data': 'tglpinjaman'},
                            {'data': 'pokokpinjaman'},
                            {'data': 'bungapinjaman'},
                            {'data': 'lamapinjaman'},
                            {'data': 'angsuranpokok'},
                            {'data': 'angsuranbunga'},
                            {'data': 'accpetugas'},
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
                    });
                    console.log(data);
                }
    });
    
    function getInputValue(){
        nopinjaman = $('#nopinjaman').val();
        noanggota = $("#noanggota").val();
        tglpinjaman = $('#tglpinjaman').val();
        pokokpinjaman = $('#pokokpinjaman').val();
        bungapinjaman = $('#bungapinjaman').val();
        lamapinjaman = $('#lamapinjaman').val();
        angsuranpokok = $('#angsuranpokok').val();
        angsuranbunga = $('#angsuranbunga').val();
        accpetugas = $('#accpetugas').val();
        persenbunga = $('#persen').val();
    }
    
    $('#btnAdd').click(function(){
        $('#btnSave').show();
        $('#submitEdit').hide();
        $('#btnSave').html('SIMPAN');
        $('#myModal').fadeIn();
        $('#titel-modal').html("Tambah Data");
        $('#nopinjaman').prop('disabled',false);
        page="tambah";
        console.log(page);
    });
    
    
    $('#tabelpinjaman tbody').on('click','#btnEdit', function(){
        $('#myModal').fadeIn();
        $('#btnSave').hide();
        $('#submitEdit').show();
        $('#title-modal').html("Edit Data");
        $('#nopinjaman').prop('disabled', true);
        page="tampil";
        var baris = $(this).closest('tr');
        var nopinjaman = baris.find('td:eq(0)').text();
        $.post('/Koperasi/pinjamanCtr', {
            page: page,
            nopinjaman: nopinjaman
        },
            function(data, status){  
                console.log(page);
                $('#nopinjaman').val(data.nopinjaman);
                $('#noanggota').val(data.noanggota);    
                $('#tglpinjaman').val(data.tglpinjaman);
                $('#pokokpinjaman').val(data.pokokpinjaman);
                $('#lamapinjaman').val(data.lamapinjaman);
                $('#bungapinjaman').val(data.bungapinjaman);
                $('#angsuranpokok').val(data.angsuranpokok);
                $('#angsuranbunga').val(data.angsuranbunga);
                $('#accpetugas').val(data.accpetugas);
                namaNama();    
                            
                var number = new Intl.NumberFormat("de-DE", {
                    style:"currency",
                    currency: "IDR"
                })
                $('#formatpokokpinjam').val("Rp. "+number.format(data.pokokpinjaman));
                $('#formatbungapinjam').val("Rp. "+number.format(data.bungapinjaman));
                $('#formatangsuranpokok').val("Rp. "+number.format(Math.ceil(data.bungapinjaman)));
                $('#formatangsuranbunga').val("Rp. "+number.format(Math.ceil(data.angsuranbunga)));
                var persen = ( parseFloat(data.bungapinjaman)*12/parseFloat(data.lamapinjaman)*100 ) / parseFloat(data.pokokpinjaman);
                console.log(persen);

                $('#persen').val(Math.ceil(persen));
            }
        );
        page="edit";
        console.log(page);
    });
    
    $('#submitEdit').on('click', function(){
        page="edit";
        getInputValue();
        if(noanggota === ""){
           $("#noanggota").css("border-color","red");
           $('#noanggota').keyup(function(){
                $('#noanggota').css('border-color','lightgrey');
            })
           $.alert({
               icon: 'fa fa-warning',
               title: 'Gagal!',
               content: 'No Anggota Harus diisi!',
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
        }else if(accpetugas === ""){
           $("#accpetugas").css("border-color","red");
           $('#accpetugas').keyup(function(){
                $('#accpetugas').css('border-color','lightgrey');
            })
           $.alert({
               icon: 'fa fa-warning',
               title: 'Gagal!',
               content: 'No Petugas Harus diisi!',
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
            console.log(page);
            $.post('/Koperasi/pinjamanCtr', {
                page: page,
                noanggota: noanggota,
                tglpinjaman: tglpinjaman,
                pokokpinjaman: pokokpinjaman,
                bungapinjaman: bungapinjaman,
                lamapinjaman: lamapinjaman,
                angsuranpokok: angsuranpokok,
                angsurabunga: angsuranbunga,
                accpetugas: accpetugas,
                nopinjaman: nopinjaman
            },
                function(data, status){
                    if(data === "Data berhasil diedit, OK..."){
                        $.alert({
                           icon: 'fas fa-check-circle',
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
    });
    
    
    
    $('#btnSave').click(function(){
        page="tambah";
        console.log(page);
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
        }else if(noanggota === ""){
           $("#noanggota").css("border-color","red");
           $('#noanggota').keyup(function(){
                $('#noanggota').css('border-color','lightgrey');
            })
           $.alert({
               icon: 'fa fa-warning',
               title: 'Gagal!',
               content: 'No Anggota Harus diisi!',
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
        }else if(accpetugas === ""){
           $("#accpetugas").css("border-color","red");
           $('#accpetugas').keyup(function(){
                $('#accpetugas').css('border-color','lightgrey');
            })
           $.alert({
               icon: 'fa fa-warning',
               title: 'Gagal!',
               content: 'No Petugas Harus diisi!',
               buttons: {
                   ok: {
                       btnClass: 'btn-red',
                       action: function(){
                           $("#accpetugas").focus();
                           $("#accpetugas").keypress(function(){
                                $("#accpetugas").css("border-color","black")
                           })
                       }
                   }
               }
           })
        }else if(persenbunga === ""){
           $("#persen").css("border-color","red");
           $('#persen').keyup(function(){
                $('#persen').css('border-color','lightgrey');
            })
           $.alert({
               icon: 'fa fa-warning',
               title: 'Gagal!',
               content: 'Persen bunga Harus diisi!',
               buttons: {
                   ok: {
                       btnClass: 'btn-red',
                       action: function(){
                           $("#persen").focus();
                           $("#persen").keypress(function(){
                                $("#noanggota").css("border-color","black")
                           })
                       }
                   }
               }
           })
        }else if(pokokpinjaman === ""){
           $("#pokokpinjaman").css("border-color","red");
           $('#pokokpinjaman').keyup(function(){
                $('#pokokpinjaman').css('border-color','lightgrey');
            })
           $.alert({
               icon: 'fa fa-warning',
               title: 'Gagal!',
               content: 'Pokok Pinjaman Harus diisi!',
               buttons: {
                   ok: {
                       btnClass: 'btn-red',
                       action: function(){
                           $("#pokokpinjaman").focus();
                           $("#pokokpinjaman").keypress(function(){
                                $("#noanggota").css("border-color","black")
                           })
                       }
                   }
               }
           })
        }else if(lamapinjaman === ""){
           $("#lamapinjaman").css("border-color","red");
           $('#lamapinjaman').keyup(function(){
                $('#lamapinjaman').css('border-color','lightgrey');
            })
           $.alert({
               icon: 'fa fa-warning',
               title: 'Gagal!',
               content: 'Lama Pinjaman Harus diisi!',
               buttons: {
                   ok: {
                       btnClass: 'btn-red',
                       action: function(){
                           $("#lamapinjaman").focus();
                           $("#lamapinjaman").keypress(function(){
                                $("#noanggota").css("border-color","black")
                           })
                       }
                   }
               }
           })
        }else if(tglpinjaman === ""){
           $("#tglpinjaman").css("border-color","red");
           $('#tglpinjaman').keyup(function(){
                $('#tglpinjaman').css('border-color','lightgrey');
            })
           $.alert({
               icon: 'fa fa-warning',
               title: 'Gagal!',
               content: 'Tanggal Pinjaman Harus diisi!',
               buttons: {
                   ok: {
                       btnClass: 'btn-red',
                       action: function(){
                           $("#tglpinjaman").focus();
                           $("#tglpinjaman").keypress(function(){
                                $("#noanggota").css("border-color","black")
                           })
                       }
                   }
               }
           })
        }else if(nopinjaman !== "" && noanggota !== ""){
            page="tambah";
//            console.log(page);
            $.post('/Koperasi/pinjamanCtr', {
                page: page,
                nopinjaman: nopinjaman,
                noanggota: noanggota,
                tglpinjaman: tglpinjaman,
                pokokpinjaman: pokokpinjaman,
                bungapinjaman: bungapinjaman,
                lamapinjaman: lamapinjaman,
                angsuranpokok: angsuranpokok,
                angsurabunga: angsuranbunga,
                accpetugas: accpetugas
            },
                function(data, status){
                    console.log(data);
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
                    }else if(data === "Data berhasil diedit, OK..."){
                        console.log(page);
                        $.alert({
                           icon: 'fas fa-check-circle',
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
                    }else{
                        $.alert({
                            icon : 'far fa-times-circle',
                            title: 'Gagal',
                            type: 'red',
                            content: data,
                            typeAnimated: true,
                            buttons: {
                                ok: {
                                    btnClass: 'btn-red',
                                    action: function(){  
                                    }  
                                }          
                            }
                        });
                    }
                }
            )
        }
    });
    
    
    
    
    
    $('#btnBatal').click(function(){
        $('#myModal').fadeOut(); 
        $('#nopinjaman').val("");
        $("#noanggota").val("");
        $('#tglpinjaman').val("");
        $('#pokokpinjaman').val("");
        $('#bungapinjaman').val("");
        $('#lamapinjaman').val("");
        $('#angsuranpokok').val("");
        $('#angsuranbunga').val("");
        $('#accpetugas').val("");
        $('#formatangsuranpokok').val("");
        $('#formatbungapinjam').val("");
        $('#formatangsuranbunga').val("");
        $('#formatpokokpinjam').val("");
        $('#persen').val("");
        $('#namaanggota').val("");
        $('#namapetugas').val("");
    });
    
    
    $('#tabelpinjaman tbody').on('click','#btnDel', function(){
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
                                $.post('/Koperasi/pinjamanCtr', {
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
    
    
    
    function namaNama(){
        page="tampil";
        var noanggota = $('#noanggota').val();
        $.post('/Koperasi/anggotaCtr', {
            page: page,
            noanggota: noanggota
        },
            function(data, status){
                $('#namaanggota').val(data.nama);
            }
        )

        
        var nik = $('#accpetugas').val();
        $.post('/Koperasi/karyawanCtr', {
            page: page,
            nik: nik
        },
             function(data, status){
                 $('#namapetugas').val(data.nama);
             }
        )
    }
    
    $(document).ready(function() {
        //Untuk membuat input hanya bisa angka
        $('#nopinjaman, #noanggota, #persen, #lamapinjaman, #pokokpinjaman' ).keypress(function(e){
            if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
                return false;
            }
        })
    });
    
    function getTgl() {
        var date = $('#tglpinjaman').val();
	var today = new Date();
	var birthday = new Date(date);
	var year = 0;
	if (today.getMonth() < birthday.getMonth()) {
            year = 1;
	} else if ((today.getMonth() == birthday.getMonth()) && today.getDate() < birthday.getDate()) {
            year = 1;
	}
	var age = today.getFullYear() - birthday.getFullYear() - year;
	return age;
    }
    
})
