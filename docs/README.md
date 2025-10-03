# Michael User Guide

## Introduction
Michael is a simple command-line task manager that helps you keep track of your todos, deadlines, and events. You can add, list, mark, unmark, delete, and find tasks easily.


<img src= "https://github.com/darshhs/ip/blob/master/docs/img.png?raw=true">


## Quick Start
1. Download and run Michael.
2. Type your commands in the command line and press Enter.
3. Type `bye` to exit the application.

---

## Features

### 1. Add Task
Add a new task to your list. Supported types: todo, deadline, event.

#### Usage
- **Todo:** `todo <description>`
- **Deadline:** `deadline <description> /by <date/time>`
- **Event:** `event <description> /at <date/time>`

#### Example
```
todo read book
deadline submit report /by Sunday
event team meeting /at Monday 2pm
```

#### Expected Output
```
Got it. I've added this task:
  [T][ ] read book
Now you have 1 task(s) in the list.
```

---

### 2. List Tasks
Show all tasks in your list.

#### Usage
- `list`

#### Example
```
list
```

#### Expected Output
```
Hello there! Certainly, here are the tasks in your list:
1.[T][ ] read book
2.[D][ ] submit report (by: Sunday)
3.[E][ ] team meeting (at: Monday 2pm)
You currently have 3 task(s)
```

---

### 3. Mark Task as Done
Mark a task as completed.

#### Usage
- `mark <task_number>`

#### Example
```
mark 2
```

#### Expected Output
```
Nice! I've marked this task as done:
[D][X] submit report (by: Sunday)
```

---

### 4. Unmark Task
Mark a task as not completed.

#### Usage
- `unmark <task_number>`

#### Example
```
unmark 2
```

#### Expected Output
```
OK, I've marked this task as not done yet:
[D][ ] submit report (by: Sunday)
```

---

### 5. Delete Task
Remove a task from your list.

#### Usage
- `delete <task_number>`

#### Example
```
delete 1
```

#### Expected Output
```
Noted. I've removed this task:
[T][ ] read book
Now you have 2 task(s) in the list.
```

---

### 6. Find Task
Find tasks containing a specific keyword.

#### Usage
- `find <keyword>`

#### Example
```
find report
```

#### Expected Output
```
Here are the matching tasks in your list:
2.[D][ ] submit report (by: Sunday)
```

---

### 7. Exit
Exit the application.

#### Usage
- `bye`

#### Example
```
bye
```

#### Expected Output
```
Bye. Hope to see you again soon!
```

---

## FAQ
- **Where are my tasks saved?**
    - Tasks are saved in the `data/data.txt` file.
- **Can I edit a task?**
    - No, you must delete and re-add the task.

---


