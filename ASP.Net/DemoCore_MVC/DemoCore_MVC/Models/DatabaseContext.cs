using Microsoft.EntityFrameworkCore;

namespace DemoCore_MVC.Models
{
    public class DatabaseContext : DbContext
    {
        public DatabaseContext(DbContextOptions options):base(options) { }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
            modelBuilder.Entity<Employee>().HasKey(e => e.Emp_id);
        }
        public DbSet<Employee> Employees { get; set; }
    }
}
