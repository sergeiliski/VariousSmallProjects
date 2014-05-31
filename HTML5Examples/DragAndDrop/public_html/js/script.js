var sourceContainerId = '';

var dragStart = function(e) {
    $(this).addClass('drag');

    try {
        e.dataTransfer.setData('text/plain', e.target.id);
    } catch (ex) {
        e.dataTransfer.setData('Text', e.target.id);
    }

    sourceContainerId = this.parentElement.id;
};

var dragOver = function(e) {
    cancel(e);
    $(this).addClass('over');
};

var dragLeave = function(e) {
    $(this).removeClass('over');
};

var dragEnd = function(e) {
    $('.drag').removeClass('drag');
    $('.over').removeClass('over');
};

var dropped = function(e) {
    cancel(e);
    
    var id, dropped;
    try {
        id = e.dataTransfer.getData('text/plain');
    } catch (ex) {
        id = e.dataTransfer.getData('Text');
    }

    dropped = document.querySelector('#' + id);
    if (this.id !== sourceContainerId) {
        e.target.appendChild(dropped);
        $(dropped).removeClass('drag');
    }

    $(this).removeClass('over');
};

var cancel = function(e) {
    if (e.preventDefault) {
        e.preventDefault();
    }

    if (e.stopPropagation) {
        e.stopPropagation();
    }

    return false;
};

forEach = Array.prototype.forEach;

var selector = '[data-role="drag-drop-container"]';
var containers = document.querySelectorAll(selector);

forEach.call(containers, function(c) {
    c.addEventListener('drop', dropped, false);
    c.addEventListener('dragenter', cancel, false);
    c.addEventListener('dragover', dragOver, false);
    c.addEventListener('dragleave', dragLeave, false);
});

var selector = '[draggable="true"]';
var draggable = document.querySelectorAll(selector);

forEach.call(draggable, function(source) {
    source.addEventListener('dragstart', dragStart, false);
    source.addEventListener('dragend', dragEnd, false);
});


