<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Redirect;
use PhpParser\Node\Expr\FuncCall;

class CategoriesControoler extends Controller
{

    public function __construct(Request $request)
    {
        /*Neu la trang categories thi hien ra dong chu*/
        // if($request->is('categories')){
        //     echo 'Test request->is()';
        //     echo 'dang dung o trang'.$request->path();
        // }
    }

    //Hien thi danh sach chuyen muc (get)
    public function index(Request $request){

        /*
            lay ra Url
            $url = $request->url();
            echo $url;
            $fullURL = $request->fullUrl();
            echo $fullURL;
        */

        /*
            Cach kiem tra phuong thuc hien tai cua trang web
            Cach 1:
            $method = $request->method();
            echo $method;
            Cach 2:
            if($request->isMethod('GET')){
            echo 'Phuong Thuc GET';
            }
        */

        /*
            Cach lay ip
            $ip = $request->ip();
            echo $ip;
        */
        /*
            lay du lieu bang $request:
            + $id = $request->id;
            echo $id;
            + $id = $request->input('id');
            echo $id;
            + $query = $request->query();
            return $query; Hoac la dd($query)
        */


        return view('client/categories/list');

    }

    //Lay ra 1 chuyen muc theo id(get)
    public function getCategory($id){
        return view('client/categories/edit');
    }

    //update chuyen muc theo id(post)
    public function updateCategory($id){
        return 'Submit sua chuyen muc';
    }

    //show form add du lieu(get)
    public function addCategory(Request $request){

        // $product_id = $request->old('product_id');
        // $product_name = $request->old('product_name');

        return view('client/categories/add');
    }

    //Thuc hien them du lieu vao chuyen muc(post)
    public function handleAddCateory(Request $request){

        // return 'submit them chuyen muc';
        /*
            kiem tra xem 1 input co ton tai hay ko
        */
        if($request->has('product_name')){
            $product_id = $request->product_id;
            $product_name = $request->product_name;
            $request->flash();
            return redirect(route('categories.add'));
        }else{
            echo 'Khong co';
        }

        // return Redirect(route('categories.add'));
    }

    //xoa du lieu (delete)
    public function deleteCategory($id){
        return 'Xoa chuyen muc';
    }

    //Hien thi form file
    public function getFormUpload(){
        return view('client/categories/file');
    }

    //Xu ly thong tin file
    public function handleFile(Request $request){
        if($request->hasFile('photo')){
            if($request->photo->isValid()){
                // $file = $request->file('photo');
                $file = $request->photo;
                // $path = $file->path();
                // $ext = $file->extension();
                //$path = $file->store('images','local'); Luu xuong storage->app->images, mac dinh la local
                //$path = $file->storeAs('file-txt', "huongdan.txt"); //doi ten file
                // $fileName = $file->getClientOriginalName(); // Lay ten file goc
                // dd($fileName);
            }else{
                return 'Upload khong thanh cong';
            }
        }else{
            return 'Vui long chon file';
        }

    }
}
