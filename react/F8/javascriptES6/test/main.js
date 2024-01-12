const listFile = ["file1", "file2", "file3", "file10", "file11"]
const listImage = ["file0", "file2", "file5", "file1", "file6", "file3"]

for (let i = 0; i < listFile.length; i++) {
    if (!listImage.includes(listFile[i])) {
        listImage.push(listFile[i]);
    }
}
console.log("List Image = ", listImage);