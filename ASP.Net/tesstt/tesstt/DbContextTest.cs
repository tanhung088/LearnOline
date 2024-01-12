using System;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity;
using System.Linq;

namespace tesstt
{
	public partial class DbContextTest : DbContext
	{
		public DbContextTest()
			: base("name=DbContextTest")
		{
		}

		public virtual DbSet<book> books { get; set; }
		public virtual DbSet<user> users { get; set; }

		protected override void OnModelCreating(DbModelBuilder modelBuilder)
		{
			modelBuilder.Entity<book>()
				.Property(e => e.title)
				.IsUnicode(false);

			modelBuilder.Entity<book>()
				.Property(e => e.author)
				.IsUnicode(false);

			modelBuilder.Entity<book>()
				.Property(e => e.price)
				.HasPrecision(15, 2);

			modelBuilder.Entity<book>()
				.Property(e => e.image)
				.IsUnicode(false);

			modelBuilder.Entity<user>()
				.Property(e => e.userName)
				.IsUnicode(false);

			modelBuilder.Entity<user>()
				.Property(e => e.email)
				.IsUnicode(false);

			modelBuilder.Entity<user>()
				.Property(e => e.password)
				.IsUnicode(false);

			modelBuilder.Entity<user>()
				.Property(e => e.role)
				.IsUnicode(false);
		}
	}
}
