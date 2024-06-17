$(document).ready(function(){
    var nik, nama, gender, tmpLahir, tglLahir, alamat, telepon, page;
    
    function getInputValue(){
        nik = $("#nik").val();
        nama = $("#nama").val();
        gender = $("#gender").children("option:selected").val();
        tmpLahir = $("#tmplahir").val();
        tglLahir = $("#tgllahir").val();
        alamat = $("#alamat").val();
        telepon = $("#telepon").val();
    }
    
    $('#backHome').click(function(){
       window.history.back(); 
    });
    
    
    $("#btnAdd").click(function(){
       $('#btnSave').html('SIMPAN');
       $("#myModal").fadeIn();
       $("#titel1").show();
       $("#titel2").hide();
       $("#nik").prop('disabled',false);
       page="tambah";
    });
    
    $('#tabelkaryawan tbody').on('click','#btnDel', function(){
       var baris = $(this).closest('tr');
       var nik = baris.find("td:eq(0)").text();
       console.log(nik);
       var nama = baris.find("td:eq(1)").text();
       page="hapus";
       
       $.confirm({
            title: 'Warning!',
            content: 'Apakah anda yakin ingin menghapus nik '+nik+" - " + nama +" ?",
            buttons: {
                yes: {
                    btnClass: 'btn-red',
                    action: function(data, status){
                                $.post('/Koperasi/karyawanCtr', {
                                    page: page,
                                    nik: nik
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
    
    $('#sidebarBuka').click(function(){
       $('#sidebar').toggleClass('active'); 
       console.log("Slide-slide")
    });
    
        $('#tabelkaryawan tbody').on('click','#btnEdit', function(){
           $("#myModal").fadeIn();
           $("#titel1").hide();
           $("#titel2").show();
           $('#nik').prop('disabled',true);
           $('#btnSave').html('EDIT');
           page="tampil";
           var baris = $(this).closest('tr');
           var nik = baris.find('td:eq(0)').text();
           $.post('/Koperasi/karyawanCtr', {
                   page: page,
                   nik: nik
               },
                function(data, status){
                    $('#nik').val(data.nik);
                    $('#nama').val(data.nama);
                    $('#gender').val(data.gender);
                    $('#tmplahir').val(data.tmpLahir);
                    $('#tgllahir').val(data.tglLahir);
                    $('#alamat').val(data.alamat);
                    $('#telepon').val(data.telepon);
                }
           );   
           page="edit";
        });
                        
    
    $("#btnSave").click(function(){
       getInputValue();
       console.log(page);
       if(nik === ""){
           $("#nik").css("border-color","red");
           $.alert({
               icon: 'fa fa-warning',
               title: 'Gagal!',
               content: 'Nik Harus diisi!',
               buttons: {
                   ok: {
                       btnClass: 'btn-red',
                       action: function(){
                           $("#nik").focus();
                           $("#nik").keypress(function(){
                                $("#nik").css("border-color","black")
                           })
                       }
                   }
               }
           })
       }else if(nama === ""){
           $("#nama").css("border-color","red");
           $.alert({
               icon: 'fa fa-warning',
               title: 'Gagal!',
               content: 'Nama Harus diisi!',
               buttons: {
                   ok: {
                       btnClass: 'btn-red',
                       action: function(){
                           $("#nama").focus();
                           $("#nama").keypress(function(){
                                $("#nama").css("border-color","black")
                           })
                       }
                   }
               }
           })
       }else{
           $.post('/Koperasi/karyawanCtr', {
               page: page,
               nik: nik,
               nama: nama,
               gender: gender,
               tmpLahir: tmpLahir,
               tglLahir: tglLahir,
               alamat: alamat,
               telepon: telepon
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
                    }else if(data === "Data Berhasil di Edit"){
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
            );   
       }
    });
    
    $("#btnCancel").click(function(){
       $("#myModal").fadeOut(); 
       $('#nik').val("");
        $('#nama').val("");
        $('#gender').val("");
        $('#tmplahir').val("");
        $('#tgllahir').val("");
        $('#alamat').val("");
        $('#telepon').val("");
    });
    
        $.ajax({
        url: '/Koperasi/karyawanCtr',
        method: "GET",
        dataType: "json",
        success:
          function(data){
            $("#tabelkaryawan").dataTable({
            serverside: true,
            processing: true,
            data: data,
            sort: true,
            searching: true,
            paging: true,
            columns:[
                {'data':'nik','name':'nik','type':'string'},
                {'data': 'nama'},   
                {'data': 'gender'},
                {'data': 'tmpLahir'},
                {'data': 'tglLahir', className: 'text-center'},
                {'data': 'alamat'},
                {'data': 'telepon'},    
                {'data': null, 'className': 'dt-right',
                    'mRender': function(o){
                        return "<a class='btn btn-outline-success btn-sm'"
                        +"id='btnEdit'>Edit</a>"
                        +"&nbsp;&nbsp;"
                        +"<a class='btn btn-outline-danger btn-sm'"
                        +"id='btnDel'>Delete</a>";
                    }
                }
            ]
        });
//        console.log(data);
        }
    });
    
    
    $("#nik, #telepon").keypress(function(data){
            if(data.which!=8 && data.which!=0 && (data.which<48 || data.which>57))
            {
                $("#pesan").html("isikan angka").show().fadeOut("slow");
                return false;
            }
        });
        
        
});
