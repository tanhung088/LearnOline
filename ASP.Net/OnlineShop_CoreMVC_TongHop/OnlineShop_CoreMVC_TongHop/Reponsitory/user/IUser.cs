using OnlineShop_CoreMVC_TongHop.Models;

namespace OnlineShop_CoreMVC_TongHop.Reponsitory.user
{
	public interface IUser
	{
		List<User> GetAllProducts();

		//
		User GetProduct(int id);
		void CreateProduct(User pro);

		void UpdateProduct(User pro);

		void DeleteProduct(int id);
	}
}
