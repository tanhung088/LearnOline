//Ung dung dung de luu du lieu vao local Storage voi bat koi du lieu nao

function createLocalStorage(key){
    //O day ko tao ra 1 ham de ung dung closure vi trong local storage khi ta luu du lieu can crud du lieu do
    //neu viet ham se viet nhieu ham de thuc hien tung cong viec
    const store = JSON.parse(localStorage.getItem(key)) ?? {}
    const save = ()=>{
        localStorage.setItem(key, JSON.stringify(store))
    }
    const storage = {
        //trong object storage chua 3 function
        get(key){
            return store[key]
        },
        set(key,value){
            store[key] = value
            save()
        },
        delete(key){
            delete store[key]
            save() 
        }
    }
    return storage  
}
//luu nhung setting cua user tren client
const profileSetting = createLocalStorage("profile_setting")
// profileSetting.set("theme", "Dark")
// profileSetting.set("ListInfoProduct", "Table")
console.log(profileSetting.get("theme"));
console.log(profileSetting.get("ListInfoProduct"));

//==========Ung dung tao 1 app car==================
console.log("========== App Car ==============");
function createAppCar() {
    const cars = []
    return {
        add(car){
            cars.push(car)
        },
        show(){
            console.log("Danh sach xe hoi: ", cars);
        }
    }
}

const appCar = createAppCar()

appCar.add("Xe hoi 1")
appCar.add("Xe hoi 2")
appCar.show()