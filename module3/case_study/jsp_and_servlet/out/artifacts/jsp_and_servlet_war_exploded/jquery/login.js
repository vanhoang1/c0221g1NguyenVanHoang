
(function ($) {
    "use strict";

    /*==================================================================
    [ Validate ]*/
    var name = $('.validate-input input[name="name"]');
    var pass = $('.validate-input input[name="password"]');

    $('.validate-form').on('submit',function(){
        var check = true;

        if($(name).val().trim() == ''){
            showValidate(name);
            check=false;
        }


        if($(pass).val().trim()== '') {
            showValidate(pass);
            check=false;
        }

        return check;
    });


    $('.validate-form .input3').each(function(){
        $(this).focus(function(){
            hideValidate(this);
        });
    });

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }



})(jQuery);