using Microsoft.EntityFrameworkCore;

namespace OnlineShop_CoreMVC_TongHop.Models
{
	public class DatabaseContext : DbContext
	{
		public DatabaseContext(DbContextOptions options) : base(options) { }
		protected override void OnModelCreating(ModelBuilder modelBuilder)
		{
			base.OnModelCreating(modelBuilder);
			modelBuilder.Entity<Product>().HasKey(p => p.Pro_Id);
			modelBuilder.Entity<User>().HasKey(u => u.User_Id);
		}
		public DbSet<Product> Products { get; set; }
		public DbSet<User> Users { get; set; }
	}
}
