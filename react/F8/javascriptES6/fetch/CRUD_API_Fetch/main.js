//lay ul block
var listCouresBlock = document.querySelector("#listCourse");

// lay api tu json_sever da tao 
var listCouresApi = "http://localhost:3000/courses";
start = () => {
    getCoures(renderCoures);

    handleCreateForm();
}
start();

function getCoures(cb) {
    fetch(listCouresApi)
        .then(respone => {
            return respone.json();
        })
        .then(cb);
}function handleCreateForm() {
    //lay node cua btnCreate va bat event onclick
    var btnCreate = document.querySelector("#btnCreate");
    btnCreate.onclick = function () {
        // lay value cua input
        var course_name = document.querySelector("input[name = 'course_name']").value;
        var description = document.querySelector("input[name = 'description']").value;
        // dua vao data dang object
        var data = {
            course_name: course_name,
            description: description,
        }
        handleCreate(data, ()=>{
            getCoures(renderCoures);
        });
    }
}

function handleCreate(data, cb) {
    var options = {
        method: "POST", // *GET, POST, PUT, DELETE, etc.
        headers: {
            "Content-Type": "application/json",
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: JSON.stringify(data), // body data type must match "Content-Type" header
    };
    fetch(listCouresApi, options)
        .then(respone=>{
            respone.json();
        })
        .then(cb);
}

function handleDelete(id){
    var options = {
        method: "DELETE", // *GET, POST, PUT, DELETE, etc.
        headers: {
            "Content-Type": "application/json",
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
    };
    fetch(listCouresApi + "/" + id,options)
        .then(respone=>{
            respone.json()
        })
        .then(()=>{
            //sau khi gui api xoa thi thuc hien xoa no khoi DOM thong qua class
            //xac dinh node can xoa
            var couresItem = document.querySelector(".course-item-" + id);
            if(couresItem){
                couresItem.remove();
            }
        });
}
function handleUpdateForm(id){
    //tu node co class mang theo id
    var couresItem = document.querySelector(".course-item-" + id);
    // lay tu DOM gia tri cua cac node con
    var course_name = couresItem.querySelector(".course_name").innerHTML;
    var description = couresItem.querySelector(".description").innerHTML;
    console.log("Name : " , course_name);
    console.log("des : " , description);
    // lay ra node cua createForm va dua du lieu vao input
    var createForm = document.querySelector("#createForm");
    var inputName = createForm.querySelector("input[name = 'course_name']");
    var input_Description = createForm.querySelector("input[name = 'description']");
    console.log("input name : ", inputName);
    console.log("input des : ", input_Description);
    // chuyen du lieu lay duoc tu tren vao 2 input nay
    inputName.value = course_name;
    input_Description.value = description;
    console.log("type input name : ", typeof(inputName.value));
    console.log("type input des :", typeof(input_Description.value));
    // sau khi chuyen value vao va sua button create thang button update
    var btnCreate = createForm.querySelector("#btnCreate");
    btnCreate.innerHTML = "Update";
    //sau do add attribut onclick handleUpdate()
    btnCreate.setAttribute("onclick", `handleUpdate(${id})`);
    //sau do la thuc hien update thong qua API
}
function handleUpdate(id){
    var createForm = document.querySelector("#createForm");
    var inputName = createForm.querySelector("input[name = 'course_name']");
    var input_Description = createForm.querySelector("input[name = 'description']");
    var data = {
        course_name: inputName.value,
        description: input_Description.value,
    }
    var options = {
        method: "PUT", // *GET, POST, PUT, DELETE, etc.
        headers: {
            "Content-Type": "application/json",
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: JSON.stringify(data), // body data type must match "Content-Type" header
    }
    fetch(listCouresApi + "/" + id, options)
        .then(respone=>{
            respone.json();
        })
        .then(()=>{
            getCoures(renderCoures);
        });
}
function renderCoures(courses) {
    var htmls = courses.map(course => {
        return `      
            <li class="course-item-${course.id}">
                <h4 class="course_name">${course.course_name}</h4>
                <p class="description">${course.description}</p>
                <button onclick="handleDelete(${course.id})">Delete</button>
                <button onclick="handleUpdateForm(${course.id})">Update</button>
            </li>
        `;
    })
    listCouresBlock.innerHTML = htmls.join('');
}

