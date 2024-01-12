<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/
// use APP\Models\User;
// Route::get('/', function(){
//     return 'Home Page';
// });

// Route::get('/', function(){
//     return view('home');
// });
// Route::get('/form', function(){
//     return view('form');
// });
// Route::post('/home', function(){
//     return view('phuong thuc post demo');
// });
// Route::put('/home', function(){
//     return view('phuong thuc put demo');
// });
// Route::match(['get', 'post'], 'home', function(){
//     return view('form');
// });,

//Demo prefix group
// Route::get('/', function(){
//     return view('home');
// });
// Route::prefix('admin')->group(function(){
//     Route::get('home/{slug?}-{id?}.html', function($slug=null,$id=null){
//         $content = 'Phuong thuc get cua path/home voi tham so : ';
//         $content .= 'slug = '.$slug. "    ";
//         $content .= 'id = '.$id ;
//         return $content;
//         // return 'route prefix demo';
//     })->where(                 /// cach 2 ->where('id', '/d+')->where('slug', '/w+');
//         [
//             'slug' => '[a-z]+',
//             'id' => '[0-9]+'
//         ]
//     )->name('admin.home' );
//     Route::get('show-form', function(){
//         return view("form");
//     }) ->name('admin.show-form') ;

//     Route::prefix('products')->group(function(){
//         Route::get('add', function(){
//             return 'Add new';
//         })->name('admin.products.add');
//         Route::get('edit', function(){
//             return 'edit product';
//         });
//     });
// });
// //thong qua controller
// use App\Http\Controllers\HomeController;
// // Route::get('/', [HomeController::class, 'index']);
// Route::get('/getnews/{id?}', [HomeController::class, 'getNews']);
////////////////////CategoryController
use App\Http\Controllers\CategoriesControoler;

//Client Route
Route::middleware('auth.admin')->prefix('categories')->group(function(){
    Route::get('/', [CategoriesControoler::class, 'index'])->name('categories.list');

    //Lay chi tiet 1 chuyen muc theo id
    Route::get('/edit/{id}', [CategoriesControoler::class, 'getCategory'])->name('categories.edit');

    //Xu ly update du lieu voi phuong thuc post
    Route::post('/edit/{id}', [CategoriesControoler::class, 'updateCategory'])->name('categories.update');

    //Add chuyen muc
    Route::get('/add', [CategoriesControoler::class, 'addCategory'])->name('categories.add');

    //Xu ly them du lieu
    Route::post('/add', [CategoriesControoler::class, 'handleAddCateory'])->name('categories.add.handleAdd');

    //Xoa chuyen muc
    Route::delete('/delete/{id}', [CategoriesControoler::class, 'deldeleteCategoryete'])->name('categories.delete');

    //Hien thi form uploang
    Route::get('/upload', [CategoriesControoler::class, 'getFormUpload']);

    //Xu ly file
    Route::post('/upload', [CategoriesControoler::class, 'handleFile'])->name('categories.upload');

});

//Adim Route
use App\Http\Controllers\Admin\ProductsController;
use App\Http\Controllers\Admin\DashboardController;

Route::middleware('auth.admin')->prefix('admin')->group(function(){
    Route::get('/', [DashboardController::class, 'index']);
    Route::resource('products',ProductsController::class)->middleware('auth.admin.product');

});
//Route cho phan hoc ve View
use App\Http\Controllers\HomeController;
Route::get('/', [HomeController::class, 'index'])->name('home')->middleware('auth.admin');
