let studentList = document.getElementById("studentUl");

//Getting list of students when opening the webpage
getStudents();

//Form button action.
document.getElementById("createStudentButton")
.addEventListener("click", e =>{
    e.preventDefault();

    let rand = Math.random().toString(16).substr(2, 4);
    let nameSplit = document.getElementById("name").value.split(' ');

    let student = {
        name: document.getElementById("name").value,
        age: document.getElementById("age").value,
        studentID: rand + "-" + nameSplit[0],
        groupID: document.getElementById("groupID").value,
        email: document.getElementById("email").value,
        number: document.getElementById("number").value
    }

    fetch("http://localhost:8080/addstudent",
        {
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify(student)
        })
        .then(response => response.text())
        .then(data => alert(data))
        .then(() => getStudents())
})


function getStudents()
{

    var table = document.getElementById("studentTable");
    table.getElementsByTagName("tbody")[0].innerHTML = table.rows[0].innerHTML;
    fetch("http://localhost:8080/students")
    .then(response => response.json())
    .then( data =>
    {
        const table = document.getElementById("studentTable");
        
        data.forEach(element => {
        let row = table.insertRow();
        let cell = row.insertCell();
        cell.innerHTML = element.name;
        cell = row.insertCell();
        cell.innerHTML = element.age;
        cell = row.insertCell();
        cell.innerHTML = element.studentID;
        cell = row.insertCell();
        cell.innerHTML = element.groupID;
        cell = row.insertCell();
        cell.innerHTML = element.email;
        cell = row.insertCell();
        cell.innerHTML = element.number;
        });
    })
}