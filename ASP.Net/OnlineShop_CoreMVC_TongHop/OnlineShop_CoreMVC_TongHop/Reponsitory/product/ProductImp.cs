using OnlineShop_CoreMVC_TongHop.Models;
using OnlineShop_CoreMVC_TongHop.Reponsitory.product;

namespace OnlineShop_CoreMVC_TongHop.Reponsitory
{
	public class ProductImp : IProduct
	{
		private DatabaseContext _dbContext;

		//khoi tao ham dung constructor non parm
		public ProductImp(DatabaseContext dbContext)
		{
			_dbContext = dbContext;
		}
		public void CreateProduct(Product pro)
		{
			_dbContext.Products.Add(pro);
			_dbContext.SaveChanges();
		}

		public void DeleteProduct(int id)
		{
			var pro = _dbContext.Products.SingleOrDefault(p => p.Pro_Id.Equals(id));
			if (pro != null)
			{
				_dbContext.Products.Remove(pro);
				_dbContext.SaveChanges();
			}
			else
			{
				Console.WriteLine("Khong tim thay product de delete!!!");
			}
		}

		public List<Product> GetAllProducts()
		{
			var listPro = _dbContext.Products.ToList();
			return listPro;
		}

		public Product GetProduct(int id)
		{
			var pro = _dbContext.Products.SingleOrDefault(p => p.Pro_Id.Equals(id));
			return pro;
		}

		public void UpdateProduct(Product proUpdate)
		{
			//dua tren 1 product da lay va tao 1 product tu trong db ma co id giong voi product lay ben view
			var pro = _dbContext.Products.SingleOrDefault(p => p.Pro_Id.Equals(proUpdate.Pro_Id));
			if (pro != null)
			{
				pro.Pro_Name = proUpdate.Pro_Name;
				pro.Pro_Des = proUpdate.Pro_Des;
				pro.UnitPrice = proUpdate.UnitPrice;
				pro.Quantity = proUpdate.Quantity;
				pro.Discount = proUpdate.Discount;
				_dbContext.SaveChanges();
			}
		}
	}
}
