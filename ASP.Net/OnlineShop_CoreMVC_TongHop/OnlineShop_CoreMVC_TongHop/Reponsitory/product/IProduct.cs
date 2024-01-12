using OnlineShop_CoreMVC_TongHop.Models;

namespace OnlineShop_CoreMVC_TongHop.Reponsitory.product
{
	public interface IProduct
	{
		List<Product> GetAllProducts();

		//
		Product GetProduct(int id);
		void CreateProduct(Product pro);

		void UpdateProduct(Product pro);

		void DeleteProduct(int id);
	}
}
