$(document).ready(function () {
    // Creates an ajax request upon search form submit
    var ajaxFormSubmit = function () {
        var $form = $(this);

        var options = {
            url: $form.attr("action"),
            type: $form.attr("method"),
            data: $form.serialize()
        };

        $.ajax(options).done(function (data) {
            var $target = $($form.attr("data-nn-target"));
            var $newHtml = $(data);
            $target.html($newHtml);
            $newHtml.effect("highlight");
        });

        updateBreadcrumb();

        // Prevent default action
        return false;
    };

    // Submits the search form upon selection of autocomplete option
    var submitAutoCompleteForm = function (event, ui) {
        var $input = $(this);
        $input.val(ui.item.label);

        var $form = $input.parents("form:first");
        $form.submit();
    };

    // Adds autocomplete to the search
    var createAutoComplete = function () {
        var $input = $(this);

        var options = {
            source: $input.attr("data-nn-autocomplete"),
            select: submitAutoCompleteForm
        };

        $input.autocomplete(options);
    };

    // Adds Ajax to pagination of search results
    var getPage = function () {
        var $a = $(this);

        var options = {
            url: $a.attr("href"),
            type: "get",
            data: $("form").serialize()
        };

        $.ajax(options).done(function (data) {
            var $target = $($a.parents("div.pagedlist").attr("data-nn-target"));
            var $newHtml = $(data);
            $target.html($newHtml);
            $newHtml.effect("highlight");
        });

        //updateBreadcrumb();

        // Prevent default action
        return false;
    };

    // Adds the current search query to the breadcrumb
    var updateBreadcrumb = function () {
        var $q = $("#q").val();
        $(".breadcrumb").empty();
        $(".breadcrumb").append("<li><a href=\"\/Show\/Index\/\">Shows</a></li>");
        $(".breadcrumb").append("<span class=\"divider\"> / </span>");
        $(".breadcrumb").append("<li class=\"active\"> Search results for: " + $q + "</li>");
    };

    // Display login modal
    var displayLoginModal = function () {
        $("#loginModalTarget").modal({ show: 'show', keyboard: true });
        $('#loginModalTarget').attr('tabindex', -1);
    };

    // Display register modal
    var displayRegisterModal = function () {
        $("#registerModalTarget").modal({ show: 'show', keyboard: true });
        $('#registerModalTarget').attr('tabindex', -1);
    };

    // Display admin modal
    var displayAdminModal = function () {
        $("#adminModalTarget").modal({ show: 'show', keyboard: false });
        $('#adminModalTarget').attr('tabindex', -1);
    };

    // Display contact modal
    var displayContactModal = function () {
        $("#contactModalTarget").modal({ show: 'show', keyboard: false });
        $('#contactModalTarget').attr('tabindex', -1);
    };

    // Display login modal from register modal
    var displayLoginFromRegistration = function () {
        $("#registerModalTarget").modal('hide');
        $("#loginModalTarget").modal({ show: 'show', keyboard: true });
        $('#loginModalTarget').attr('tabindex', -1);
    };

    // Display register modal from login modal
    var displayRegisterFromLogin = function () {
        $("#loginModalTarget").modal('hide');
        $("#registerModalTarget").modal({ show: 'show', keyboard: true });
        $('#registerModalTarget').attr('tabindex', -1);
    };

    /* TOOLTIPS */
    $("#popdb").tooltip({ title: 'This will populate the entire database with new series and episodes.' });
    $("#upddb").tooltip({ title: 'This should crawl one series in particular and check for new episodes + downloads.' });

    // Adds tooltips to every show in the overview
    $('#main').tooltip({
        selector: "a[rel=tooltip]"
    });

    // Adds a carousel to the show overview
    $("#myCarousel").carousel({
        interval: 7000
    });

    /* Events tracked */
    $("form[data-nn-ajax='true']").submit(ajaxFormSubmit);
    $("input[data-nn-autocomplete]").each(createAutoComplete);
    $(".container").on("click", ".pagedlist a", getPage);
    $("#loginModal").on("click", displayLoginModal);
    $("#registerLoginModal").on("click", displayLoginFromRegistration);
    $("#registerModal").on("click", displayRegisterModal);
    $("#loginRegistrationModal").on("click", displayRegisterFromLogin);
    $("#adminModal").on("click", displayAdminModal);
    $("#contactModal").on("click", displayContactModal);
    $("#errorContact").on("click", displayContactModal);
    $("#validationContact").on("click", displayContactModal);
});