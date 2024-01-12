//tao 1 fake api
//tao 1 mang user co chua id va name
const users = [
    {
        user_name: "Tan Hung",
        user_id: 1
    },
    {
        user_name:"Trung Nhan",
        user_id:2
    },
    {
        user_name:"Duy Thanh",
        user_id: 3
    },
    {
        user_name:"Tien Sy",
        user_id: 4
    }
];
//tao 1 mang comment, moi cmt tuong ung la 1 id cua user
const comments = [
    {
        comment: "Bai nay rat hay va huu ich cho toi",
        cmt_id: 1,
        user_id: 2
    },
    {
        comment: "Toi dang thac mac ve doan code nay",
        cmt_id: 2,
        user_id: 1,
    },
    {
        comment:"Oke! Toi da hieu",
        cmt_id: 3,
        user_id: 1
    },
    {
        comment: "Vang cam on ve bai hoc nay",
        cmt_id: 4,
        user_id:3
    }
]
//Lay commet tu fake api
// ham getComments return ve 1 Promise chua mang comments va bi cham 1s tuong ung khi chung ta lay api tren web
const getComments = ()=>{
    return new Promise(resolve=>{
        setTimeout(()=>{
            resolve(comments);
        }, 1000);
    })
}

//lay user_id tu fake api ma co id tuong ung voi id trong commets array
const getUserIdbyUserIdCmt = (userIds)=>{
    return new Promise(resolve=>{
        setTimeout(()=>{
            var userHaveCmt = users.filter(user=>{
                return userIds.includes(user.user_id);
            });
            resolve(userHaveCmt);
            //ham nay tra ve 1 mang chua userid co cmt
        }, 1000)
    })
}

getComments()
    .then(commentsss=>{
        //tu getCommnet() lay ra user_id trong array commnets va dua vao mang userIds_cmt
        var userIds_cmt = comments.map(cmt=>{
            return cmt.user_id;
        });
        //lay ra user ma co user_id tuong ung voi tung ele trong mang userIds_cmt
        //Thong qua ham getUserIdbyUserIdCmt
        return getUserIdbyUserIdCmt(userIds_cmt)
            .then(userHaveCmt=>{
                //console.log("userHaveCmt",userHaveCmt);
                return {
                    user: userHaveCmt,
                    cmt: commentsss
                };
            })
            
    })
    .then(data=>{
        //console.log("data", data);
        let html = "";
        var cmt_block = document.getElementById("cmt_block");
        //console.log(cmt_block);
        data.cmt.forEach(cmt=>{
            var user = data.user.find(user=>{
                return user.user_id == cmt.user_id;
            })
            html += `<li>${user.user_name}: ${cmt.comment}</li>`
        })
        cmt_block.innerHTML = html;
    })
