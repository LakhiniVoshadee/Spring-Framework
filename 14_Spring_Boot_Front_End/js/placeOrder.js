document.addEventListener('DOMContentLoaded', function() {
  loadOrders();

  // Save new order
  document.getElementById('saveOrderBtn').addEventListener('click', saveOrder);

  // Update existing order
  document.getElementById('updateOrderBtn').addEventListener('click', updateOrder);
});

// Load all orders from the backend
function loadOrders() {
  fetch('http://localhost:8080/api/orders') // Assuming you have an endpoint that returns all orders
    .then(response => response.json())
    .then(data => {
      let tableBody = document.getElementById('orderTableBody');
      tableBody.innerHTML = ''; // Clear the table

      data.forEach(order => {
        let row = document.createElement('tr');
        row.innerHTML = `
                    <td>${order.id}</td>
                    <td>${order.customerId}</td>
                    <td>${order.orderDate}</td>
                    <td>
                        <button class="btn btn-warning btn-sm" onclick="editOrder(${order.id})">Edit</button>
                        <button class="btn btn-danger btn-sm" onclick="deleteOrder(${order.id})">Delete</button>
                    </td>
                `;
        tableBody.appendChild(row);
      });
    });
}

// Save new order
function saveOrder() {
  const customerId = document.getElementById('customerId').value;
  const orderDate = document.getElementById('orderDate').value;
  const orderDetails = JSON.parse(document.getElementById('orderDetails').value);

  const orderData = {
    customerId: customerId,
    orderDate: orderDate,
    orderDetails: orderDetails
  };

  fetch('http://localhost:8080/api/orders/place', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(orderData)
  })
    .then(response => response.json())
    .then(() => {
      loadOrders();
      clearModal();
      alert('Order placed successfully!');
    })
    .catch(err => alert('Error: ' + err));
}

// Edit order
function editOrder(orderId) {
  fetch(`http://localhost:8080/api/orders/${orderId}`) // Assuming you have an endpoint for fetching a specific order
    .then(response => response.json())
    .then(order => {
      document.getElementById('orderModalLabel').innerText = 'Edit Order';
      document.getElementById('customerId').value = order.customerId;
      document.getElementById('orderDate').value = order.orderDate;
      document.getElementById('orderDetails').value = JSON.stringify(order.orderDetails);
      document.getElementById('saveOrderBtn').style.display = 'none';
      document.getElementById('updateOrderBtn').style.display = 'block';
      document.getElementById('updateOrderBtn').setAttribute('data-id', order.id);
    });
}

// Update order
function updateOrder() {
  const orderId = document.getElementById('updateOrderBtn').getAttribute('data-id');
  const customerId = document.getElementById('customerId').value;
  const orderDate = document.getElementById('orderDate').value;
  const orderDetails = JSON.parse(document.getElementById('orderDetails').value);

  const orderData = {
    customerId: customerId,
    orderDate: orderDate,
    orderDetails: orderDetails
  };

  fetch(`http://localhost:8080/api/orders/${orderId}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(orderData)
  })
    .then(response => response.json())
    .then(() => {
      loadOrders();
      clearModal();
      alert('Order updated successfully!');
    })
    .catch(err => alert('Error: ' + err));
}

// Delete order
function deleteOrder(orderId) {
  fetch(`http://localhost:8080/api/orders/${orderId}`, {
    method: 'DELETE',
  })
    .then(response => response.json())
    .then(() => {
      loadOrders();
      alert('Order deleted successfully!');
    })
    .catch(err => alert('Error: ' + err));
}

// Clear modal
function clearModal() {
  document.getElementById('orderModalLabel').innerText = 'Add Order';
  document.getElementById('customerId').value = '';
  document.getElementById('orderDate').value = '';
  document.getElementById('orderDetails').value = '';
  document.getElementById('saveOrderBtn').style.display = 'block';
  document.getElementById('updateOrderBtn').style.display = 'none';
}
