using Microsoft.EntityFrameworkCore;
using OnlineShop_CoreMVC_TongHop.Models;
using OnlineShop_CoreMVC_TongHop.Reponsitory;
using OnlineShop_CoreMVC_TongHop.Reponsitory.Admin;
using OnlineShop_CoreMVC_TongHop.Reponsitory.product;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllersWithViews();

//config de connect db thong qua appsetting.json
builder.Services.AddDbContext<DatabaseContext>(options => options.UseSqlServer(builder.Configuration.GetConnectionString("ConnectDB")));
//DI(dependencie injection) theo co che (inversion control) interface
builder.Services.AddScoped<IProduct, ProductImp>();
builder.Services.AddScoped<IAdmin, AdminImp>();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
	app.UseExceptionHandler("/Home/Error");
}
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

//app.MapControllerRoute(
//	name: "default",
//	pattern: "{controller=Admin}/{action=Index}/{id?}");

app.UseEndpoints(endpoints =>
{
	endpoints.MapControllerRoute(
	  name: "Admin",
	  pattern: "{area:exists}/{controller=Admin}/{action=Index}/{id?}");
	endpoints.MapControllerRoute(
	  name: "Product",
	  pattern: "{area:exists}/{controller=Product}/{action=Index}/{id?}");
    endpoints.MapControllerRoute(
      name: "Login",
      pattern: "{area:exists}/{controller=Login}/{action=Index}/{id?}");
    endpoints.MapControllerRoute(
	  name: "default",
	  pattern: "{controller=Home}/{action=Index}/{id?}");
});

app.Run();
