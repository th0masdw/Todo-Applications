var myTasks = Alloy.Collections.tasks;

var task = Alloy.createModel('tasks', { 
   name : 'Play guitar', 
   owner: 'Thomas' 
});

myTasks.add(task); 
task.save();

function showTask(event) {
    var selectedTask = event.source;
    var args = {
        name: selectedTask.name,
        owner: selectedTask.owner
    };
    var taskview = Alloy.createController("taskdetails", args).getView();
    if (OS_IOS) {
        $.index.openWindow(taskview);
    }
    if (OS_ANDROID) {
        taskview.open();
    }  
}

function addTask(){
    var myAddTask = Alloy.createController("addtask",{}).getView();
    if (OS_IOS) {
        $.index.openWindow(myAddTask);
    }
    if (OS_ANDROID) {
        myAddTask.open();
    }
}

$.index.open();