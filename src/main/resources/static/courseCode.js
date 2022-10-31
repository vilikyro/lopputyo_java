let courseList = document.getElementById("courseUl")

getCourses();

document.getElementById("createCourseButton")
    .addEventListener("click", e => {
        e.preventDefault()

        let rand = Math.random().toString(16).substr(2, 4);
        let courseNameSplit = document.getElementById("coursename").value.split(' ');
        let course = {
            courseName: document.getElementById("coursename").value,
            courseID: rand + "-" + courseNameSplit[0],
            teacher: document.getElementById("teacher").value,
            classRoom: document.getElementById("classRoom").value,
        }

        fetch("http://localhost:8080/addcourse",
            {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "POST",
                body: JSON.stringify(course)
            })
            .then(response => response.text())
            .then(data => alert(data))
            .then(() => getCourses())
    })

document.getElementById("addStudentToCourseButton")
    .addEventListener("click", e => {
        e.preventDefault()

        let object = {
            studentID: document.getElementById("studentID").value,
            courseID: document.getElementById("courseID").value
        }

        fetch("http://localhost:8080/addstudenttocourse",
            {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "POST",
                body: JSON.stringify(object)
            })
            .then(response => response.text())
            .then(data => alert(data))
            .then(() => getCourses())
    })

function getCourses() 
{

    var table = document.getElementById("courseTable");
    table.getElementsByTagName("tbody")[0].innerHTML = table.rows[0].innerHTML;

    fetch("http://localhost:8080/courses")
        .then(response => response.json())
        .then(data => {
            console.log(data[0].participants.length);
            console.log(data);
            const table = document.getElementById("courseTable");

            data.forEach(element => {
                let row = table.insertRow();
                let cell = row.insertCell();
                cell.innerHTML = element.courseName;
                cell = row.insertCell();
                cell.innerHTML = element.courseID;
                cell = row.insertCell();
                cell.innerHTML = element.teacher;
                cell = row.insertCell();
                cell.innerHTML = element.classRoom;
                cell = row.insertCell();
                cell.innerHTML = element.participants.length;
            });

        })
}