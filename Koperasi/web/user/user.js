$(document).ready(function(){
    var userid, password, confirmpassword, nik, nama, level, aktif, page;
   $('#sidebarBuka').click( function() {
        $('#sidebar').toggleClass('active');
    });
    
    $('#backHome').click(function(){
       window.history.back(); 
    });
    
    $.ajax({
        url: '/Koperasi/loginCtr',
        method: "GET",
        dataType: "json",
        success:
                function(data){
                    $("#tabeluser").dataTable({
                       serverside: true,
                       processing: true,
                       data: data,
                       sort: true,
                       searching: true,
                       paging: true,
                       columns:[
                           {'data': 'userid','name':'userid','type':'string', className: 'text-center'},
                           {'data': 'nik', className: 'text-center'},
                           {'data': 'namakaryawan'},
                           {'data': 'level', className: 'text-center'},
                           {'data': 'aktif', className: 'text-center'},
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
                }
    });
    
    $('#btnAdd').click(function(){
        $('#btnSave').show();
        $('#submitEdit').hide();
        $('#btnSave').html('SIMPAN');
        $('#myModal').fadeIn();
        $('#titel-modal').html("Tambah Data");
        $('#nopinjaman').prop('disabled',false);
        page="tambah"; 
    });
    $('#btnCancel').click(function(){
       $('#myModal').fadeOut();
       $('#userid').val("");
       $('#nik').val("");
       $('#nama').val("");
       $('#password').val("");
       $('#confirmpassword').val("");
       $('#level').val("");
       $('#aktif').val("");
    });
    
    $('#lookupnik').click(function(){
        $('#lookupmodal').fadeIn();
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
                    }
        });
    });
    
    $('#tabellookup tbody').on('click','#btnPilih', function(){
        $('#lookupmodal').fadeOut();
        page='tampil';
        var baris = $(this).closest('tr');
        var nik = baris.find('td:eq(0)').text();
        $.post('/Koperasi/karyawanCtr', {
            page: page,
            nik:nik
        },
             function(data, status){
                 $('#nik').val(data.nik);
                 $('#nama').val(data.nama);
             }
         );
    });
     
    $('#nik').keyup(function(){
        page='tampil';
        var baris = $(this).closest('tr');
        var nik = $('#nik').val();
        $.post('/Koperasi/karyawanCtr', {
            page: page,
            nik:nik
        },
             function(data, status){
                 $('#nama').val(data.nama);
             }
         );
    });
    
    $('#btnBackLookup').click(function(){
        $('#lookupmodal').fadeOut();
    });
    
    function getInputValue(){
        userid = $('#userid').val();
        nik = $('#nik').val();
        nama = $('#nama').val();
        password = $('#password').val();
        confirmpassword = $('#confirmpassword').val();
        level = $('#level').val();
        aktif = $('#aktif').val();
    }
    
    $('#btnSave').click(function(){
        page="tambah";
        console.log(page);
        getInputValue();
        if(userid === ""){
            $('#userid').css('border-color','red');
            $('#userid').keyup(function(){
                $('#userid').css('border-color','lightgrey');
            })
            $.alert({
               icon: 'fa fa-warning',
               title: 'Gagal!',
               content: 'User ID Harus diisi!',
               buttons: {
                   ok: {
                       btnClass: 'btn-red',
                       action: function(){
                           $("#userid").focus();
                           $("#userid").keypress(function(){
                                $("#userid").css("border-color","lightgrey")
                           })
                       }
                   }
               }
            })
        }else if(nik === ""){
           $("#nik").css("border-color","red");
           $('#nik').keyup(function(){
                $('#nik').css('border-color','lightgrey');
            })
           $.alert({
               icon: 'fa fa-warning',
               title: 'Gagal!',
               content: 'NIK Harus diisi!',
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
        }else if(userid !== "" && nik !== ""){
            if(password !== confirmpassword){
                $.alert({
                    icon: 'fa fa-warning',
                    title: 'Gagal!',
                    content: 'Konfirmasi Password salah',
                    buttons: {
                        ok: {
                            btnClass: 'btn-red',
                            action: function(){
                                $("#confirmpassword").focus();
                                $("#confirmpassword").keypress(function(){
                                     $("#confirmpassword").css("border-color","lightgrey")
                                })
                            }
                        }
                    }
                })
            }else{
                page="tambah";
                    console.log(page);
                    $.post('/Koperasi/loginCtr', {
                        page: page,
                        userid: userid,
                        password: password,
                        nik: nik,
                        level: level,
                        aktif: aktif
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
            } 
    });
});

