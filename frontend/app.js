const BASE_URL = "http://localhost:8080";

// ======================= TASK =======================

// CREATE TASK
function createTask() {
    const data = {
        title: document.getElementById("title").value,
        description: document.getElementById("desc").value,
        userId: document.getElementById("userId").value,
        categoryId: document.getElementById("categoryId").value
    };

    fetch(`${BASE_URL}/tasks`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    })
    .then(res => res.json())
    .then(data => {
        alert("Task created!");
        console.log(data);
    })
    .catch(err => console.error(err));
}

// GET TASKS
function loadTasks() {
    fetch(`${BASE_URL}/tasks`)
    .then(res => res.json())
    .then(tasks => {
        const list = document.getElementById("taskList");
        list.innerHTML = "";

        tasks.forEach(task => {
            const li = document.createElement("li");
            li.innerText = `${task.title} - ${task.status}`;
            list.appendChild(li);
        });
    });
}

// ======================= CATEGORY =======================

function loadCategories() {
    fetch(`${BASE_URL}/categories`)
    .then(res => res.json())
    .then(categories => {
        const list = document.getElementById("categoryList");
        list.innerHTML = "";

        categories.forEach(cat => {
            const li = document.createElement("li");
            li.innerText = `${cat.id} - ${cat.name}`;
            list.appendChild(li);
        });
    });
}

// ======================= NOTIFICATION =======================

function loadNotifications() {
    fetch(`${BASE_URL}/notifications`)
    .then(res => res.json())
    .then(notifications => {
        const list = document.getElementById("notificationList");
        list.innerHTML = "";

        notifications.forEach(n => {
            const li = document.createElement("li");

            li.innerText = `${n.message} | Read: ${n.isRead}`;

            // MARK AS READ BUTTON
            const btn = document.createElement("button");
            btn.innerText = "Mark Read";
            btn.onclick = () => markAsRead(n.id);

            li.appendChild(btn);
            list.appendChild(li);
        });
    });
}

// MARK AS READ
function markAsRead(id) {
    fetch(`${BASE_URL}/notifications/${id}/read`, {
        method: "PUT"
    })
    .then(res => res.json())
    .then(() => {
        alert("Marked as read");
        loadNotifications();
    });
}