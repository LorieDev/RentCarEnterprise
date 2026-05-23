const apiUrl = "/cars";

window.onload = function() {
    loadCars();
};

document.getElementById("carForm").addEventListener("submit", function(e) {
    e.preventDefault();

    const id = document.getElementById("carId").value;
    const brand = document.getElementById("brand").value;
    const model = document.getElementById("model").value;
    const price = document.getElementById("price").value;
    const year = document.getElementById("year").value;
    const color = document.getElementById("color").value;

    const carData = {
        brand: brand,
        model: model,
        price: price,
        year: year,
        color: color,
        available: true
    };

    if (id) {
        updateCar(id, carData);
    } else {
        addCar(carData);
    }
});

function addCar(carData) {
    fetch(apiUrl, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(carData)
    })
        .then(response => response.json())
        .then(() => {
            clearForm();
            loadCars();
        });
}

function loadCars() {
    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            const table = document.getElementById("carTableBody");
            table.innerHTML = "";

            data.forEach(car => {
                const statusClass = car.available ? "available" : "rented";
                const statusText = car.available ? "Available" : "Rented";
                const rentButtonText = car.available ? "Rent" : "Return";

                const row = `
                    <tr>
                        <td>${car.id}</td>
                        <td>${car.brand}</td>
                        <td>${car.model}</td>
                        <td>$${car.price}</td>
                        <td>${car.year}</td>
                        <td>${car.color}</td>
                        <td class="${statusClass}">${statusText}</td>
                        <td>
                            <button class="rentButton" onclick="toggleAvailability(${car.id}, '${car.brand}', '${car.model}', ${car.price}, ${car.year}, '${car.color}', ${car.available})">
                                ${rentButtonText}
                            </button>
                            <button class="editButton" onclick="editCar(${car.id}, '${car.brand}', '${car.model}', ${car.price}, ${car.year}, '${car.color}', ${car.available})">
                                Edit
                            </button>
                            <button class="deleteButton" onclick="deleteCar(${car.id})">
                                Delete
                            </button>
                        </td>
                    </tr>
                `;

                table.innerHTML += row;
            });
        });
}

function editCar(id, brand, model, price, year, color, available) {
    document.getElementById("carId").value = id;
    document.getElementById("brand").value = brand;
    document.getElementById("model").value = model;
    document.getElementById("price").value = price;
    document.getElementById("year").value = year;
    document.getElementById("color").value = color;

    window.currentAvailability = available;

    document.getElementById("submitButton").textContent = "Update Car";
}

function updateCar(id, carData) {
    if (window.currentAvailability !== undefined) {
        carData.available = window.currentAvailability;
    }

    fetch(`${apiUrl}/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(carData)
    })
        .then(response => response.json())
        .then(() => {
            clearForm();
            loadCars();
        });
}

function deleteCar(id) {
    fetch(`${apiUrl}/${id}`, {
        method: "DELETE"
    })
        .then(() => {
            loadCars();
        });
}

function toggleAvailability(id, brand, model, price, year, color, available) {
    const carData = {
        brand: brand,
        model: model,
        price: price,
        year: year,
        color: color,
        available: !available
    };

    updateCar(id, carData);
}

function cancelEdit() {
    clearForm();
}

function clearForm() {
    document.getElementById("carId").value = "";
    document.getElementById("brand").value = "";
    document.getElementById("model").value = "";
    document.getElementById("price").value = "";
    document.getElementById("year").value = "";
    document.getElementById("color").value = "";

    window.currentAvailability = undefined;

    document.getElementById("submitButton").textContent = "Save Car";
}