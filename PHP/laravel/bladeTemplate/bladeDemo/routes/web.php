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
use App\Http\Controllers\HomeController;
Route::get('/', [HomeController::class, 'index'])->name('home');
Route::get('/san-pham', [HomeController::class, 'product'])->name('product');
Route::get('/them-san-pham', [HomeController::class, 'add'])->name('add');
Route::post('/them-san-pham', [HomeController::class, 'handlePostAdd']);
/*
    // Route::put('/them-san-pham', [HomeController::class, 'handlePutAdd']);
    Neu dung phuong thuc put thi them @method('PUT') vao layouts add
*/

