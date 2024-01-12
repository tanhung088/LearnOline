using System;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity;
using System.Linq;

namespace onlineshop_MVC
{
	public partial class DatabaseDbContext : DbContext
	{
		public DatabaseDbContext()
			: base("name=DatabaseDbContext")
		{
		}

		public virtual DbSet<user> users { get; set; }

		protected override void OnModelCreating(DbModelBuilder modelBuilder)
		{
			modelBuilder.Entity<user>()
				.Property(e => e.user_name)
				.IsUnicode(false);

			modelBuilder.Entity<user>()
				.Property(e => e.email)
				.IsUnicode(false);

			modelBuilder.Entity<user>()
				.Property(e => e.password)
				.IsUnicode(false);
		}
	}
}
