var myTasks = Alloy.Collections.tasks;

function addTask() {
    var task = Alloy.createModel('tasks', {
        name : $.nameInput.value,
        owner : $.ownerInput.value
    });
    myTasks.add(task);
    task.save();
    // Close the window.
    $.addtask.close();
}