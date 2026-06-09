const API_BASE_URL = 'http://localhost:8080/';

const API_ENDPOINTS = {
  GET_USERS: 'users',
  ADD_USER:  'users/add',
  REMOVE_USER: 'users/delete'
};

async function getUsers() {
  const res = await fetch(`${API_BASE_URL}${API_ENDPOINTS.GET_USERS}`);

  if (!res.ok) {
    console.error('Failed to fetch users:', res.status, res.statusText);
    return;
  }

  const users = await res.json();
  const tableBody = document.getElementById('tableBody');

  const emptyRow = tableBody.querySelector('.empty-row');
  if (emptyRow) emptyRow.remove();

  users.forEach(user => {
    const tr = document.createElement('tr');
    tr.innerHTML = `
      <td>${user.id}</td>
      <td><span class="badge">${user.username}</span></td>
      <td>${user.ip}</td>
      <td><button type="button" class="btn-danger" onclick="removeUser(${user.id})">Rimuovi</button></td>
    `;
    tableBody.appendChild(tr);
  });
}

async function addUser() {
    const usernameInput = document.getElementById('usernameInput');
    const username = usernameInput.value.trim();
    
    if (!username) {
        alert('Please enter a username.');
        return;
    }

    const ipAddress = document.getElementById('ipInput').value.trim();

    if (!ipAddress) {
        alert('Please enter an IP address.');
        return;
    }

    const res = await fetch(`${API_BASE_URL}${API_ENDPOINTS.ADD_USER}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username: username, ip: ipAddress })
    });

    if (!res.ok) {
        console.error('Failed to add user:', res.status, res.statusText);
        alert('Failed to add user. Please try again.');
        return;
    }

    usernameInput.value = '';
    document.getElementById('ipInput').value = '';
    document.location.href = './player.html';
};

async function removeUser(userId) {
    const res = await fetch(`${API_BASE_URL}${API_ENDPOINTS.REMOVE_USER}/${userId}`, {
        method: 'DELETE'
    });

    if (!res.ok) {
        console.error('Failed to remove user:', res.status, res.statusText);
        alert('Failed to remove user. Please try again.');
        return;
    }

    document.location.href = './player.html';
};

getUsers();
