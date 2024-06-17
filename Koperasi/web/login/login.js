$(document).ready(function(){
    var userid, page;
    
    function getValue(){
        userid = $('#userid').val();
    }
    
    $('#btnLogin').click(function(){
        page="login";
        getValue();
        $.ajax({
            url: "/Koperasi/loginCtr",
            type: "GET",
            dataType: "JSON",
            data: {
                'userid': userid,
                'page': page
            },
            success: function(res){
                console.log(res);
                var user = $('#userid').val();
                var pw = $('#password').val();
                if(user === res.userid && pw === res.password){
                    if(res.aktif === "Y"){
                        if(res.level === "Admin"){
                            $.alert({
                                icon : 'fas fa-check-circle',
                                title: 'Berhasil',
                                type: 'blue',
                                content: "Berhasil Login",
                                typeAnimated: true,
                                buttons: {
                                    ok: {
                                        btnClass: 'btn-red',
                                        action: function(){
                                            document.location.href = "../home/admin.html";   
                                        }  
                                    }          
                                }
                            });
                            $('#welcome').html("Selamat Datang Admin "+res.namakaryawan);
                        }else{
                            $.alert({
                                icon : 'fas fa-check-circle',
                                title: 'Berhasil',
                                type: 'blue',
                                content: "Berhasil Login",
                                typeAnimated: true,
                                buttons: {
                                    ok: {
                                        btnClass: 'btn-red',
                                        action: function(){
                                            document.location.href = "../home/operator.html";     
                                        }  
                                    }          
                                }
                            });
                            $('#welcome').html("Selamat Datang Operator "+res.namakaryawan);
                        }
                    }else{
                        $.alert({
                            icon : 'far fa-times-circle',
                            title: 'Gagal',
                            type: 'red',
                            content: "userId sudah tidak aktif",
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
                }else{
                    $.alert({
                        icon : 'far fa-times-circle',
                        title: 'Gagal',
                        type: 'red',
                        content: "userId atau Password salah",
                        typeAnimated: true,
                        buttons: {
                            ok: {
                                btnClass: 'btn-red',
                                action: function(){
                                    $('#userid').val("");
                                    $('#password').val("");
                                }  
                            }          
                        }
                    });
                }           
            }
        })
    });
    
    $('#sidebarBuka').click( function() {
        $('#sidebar').toggleClass('active');
    }); 
    
    
    
});

