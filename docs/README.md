# User Guide

Ethan is a handy personal task manager which will help you maintain your task list through the Command Line Interface (CLI).

* [1. Quick Start](#quick-start)
* [2. Features](#features)
    + [2.1 Add a Todo task: `todo`](#1-adding-a-todo-task-todo)
    + [2.2 Add a Deadline task: `deadline`](#2-adding-a-deadline-task-deadline)
    + [2.2 Add an Event task: `event`](#3-adding-an-event-task-event)
    + [2.3 List all tasks: `list`](#4-listing-all-tasks-at-hand-list)
    + [2.4 Mark a task done: `done`](#5-marking-a-task-as-complete-done)
    + [2.5 Delete a task: `delete`](#6-deleting-a-task-delete)
    + [2.6 Find a task: `find`](#7-finding-a-task-find)
    + [2.7 End the program: `bye`](#8-exiting-the-program-bye)
    + [2.8 : `help`](#9-listing-available-help-help)
* [3. FAQ](#faq)
* [4. Command Summary](#command-summary)

## 1. Quick Start

1. Ensure that you have Java `11` installed in your computer.
2. Download the latest ip.jar from  link.
3. Copy the file to a folder you want to store your tasks.
4. Launch the command prompt and navigate to the folder ip.jar is stored in.
5. Run ip.jar in the command prompt `(java -jar ip.jar)`
6. Type commands in the command prompt and press Enter to run commands. e.g. type `help` and Enter to see commands available
7. Refer to features section below for other commands

## 2. Features 
There are **3** types of task, **todo**,**deadlines** and **events**

Following is a list of commands at your disposal:
* `help`- View help
* `list`- View task list
* `todo`- Add todo
* `deadline`- Add deadline
* `event`- Add event
* `done`- Mark done
* `delete`- Delete task
* `find`- Find tasks
* `bye`- End program

### 2.1 `help` - View help
Shows the commands and their respective input formats
**Format:** `help`
**Outcome:**

### 2.2 `list`- View task list
Shows list of tasks
**Format:** `list`
**Outcome:**

### 2.3 `todo`- Add todo
Adds a todo task to task list
**Format:** `todo DESCRIPTION`
**Example:** `todo wash car`
  *Adds a todo task with description "wash car" to task list
**Outcome:**


### 2.4 `deadline`- Add deadline
Adds a deadline task to task list
**Format**: `deadline DESCRIPTION /by DATE TIME`
  * `DATE` must be in **dd/MM/yyyy** format. eg `9/12/2020` for 9th december 2020
  * `TIME` must be in **HH:mm** 24 hours time format. eg `22:59` for 10:59pm.
  * `DATE TIME` must be in future
**Example:** `deadline math project /by 22/12/2020 23:59`
  *Adds a deadline task with description "deadline math project", by "22nd December 2020 23:59"
**Outcome:**

### 2.5 `event`- Add event
Adds an event to task list
**Format:** `event DESCRIPTION /at DATE TIME`
  * `DATE` must be in **dd/MM/yyyy** format. eg `9/12/2020` for 9th december 2020
  * `TIME` must be in **HH:mm** 24 hours time format. eg `22:59` for 10:59pm.
  * `DATE TIME` must be in future
**Example:** `event career workshop /at 30/12/2021 12:00`
  *Adds a event task with description "event career workshop", at "30th December 2021 12:00"
**Outcome:**

### 2.6 `done`- Mark done
Marks a task in task list as done
**Format:** `done TASKNUMBER`
  * `TASKNUMBER` must be an integer.
**Example:** `done 1`
  *Marks task with task number 1 as done.
**Outcome:**

### 2.7 `delete`- Delete task
Deletes a task from task list
**Format:** `delete TASKNUMBER`
  * `TASKNUMBER` must be an integer.
**Example** `delete 1`
  * Deletes task with task number .
**Outcome:**
