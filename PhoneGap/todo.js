var tasks = [];
var selectedTask;

var onReady = function() {
	console.log('Javascript works!');

	$('#add').on('click', function() {
		$.mobile.changePage('#newTask');
	});

	$('#submit').on('click', addTask);

	$('#remove').on('click', removeTask);
	$('#cancel').on('click', function() {
		$.mobile.changePage('#home');
	});
}

function addTask() {
	var task = $('#task').val();
	tasks.push(task);
	$('#task').val('');
	$.mobile.changePage('#home');
	loadTaskList();
}

function removeTask() {
	tasks.splice(selectedTask, 1);
	$.mobile.changePage('#home');
	loadTaskList();
}

function loadTaskList() {
	$('#tasks').html('');
	$.each(tasks, function(index, item) {
		$('#tasks').append('<li><a id="task-' + index + '">' + item + '</a></li>');
	});
	$('#tasks').listview('refresh');

	$('#tasks li a').on('click', function() {
		selectedTask = $(this).attr('id').substr($(this).attr('id').length - 1);
		$('#removeTaskInput').text($(this).text());
		$.mobile.changePage('#removeTask');
	});
}

document.addEventListener('DOMContentLoaded', onReady, false);