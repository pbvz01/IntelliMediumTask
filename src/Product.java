import java.util.ArrayList;
import java.util.Scanner;

public class Product
{
		private static int ID = 1;
		private int idProduct;
		private String productName;
		private int price;

		public Product()
		{
				this.idProduct = ID;
				setProductName();
				setPrice();
				ID++;
		}

		public Product(Product obj)
		{
				this.idProduct = obj.idProduct;
				this.productName = obj.productName;
				this.price = obj.price;
		}

		public static void deleteProduct(ArrayList<Product> list, int ID)
		{
				int size = list.size();
				if(size < 1) System.out.println("The list of product is empty");
				else
				{
						for (int i = 0; i < list.size(); i++)
						{
								if(list.get(i).getID() == ID)
								{
										System.out.println("Delete was comlite!");
										list.remove(i);
										i--;
										break;
								}
						}
						if(list.size() == size) System.out.println("ID not found");
				}
		}

		public void getTextInfoAboutProduct()
		{
				System.out.println("ID: " + this.idProduct + "; Product: " + this.productName + "; Price: " + this.price);
		}

		public int getID()
		{
			return this.idProduct;
		}

		public int getPrice()
		{
				return this.price;
		}

		public void setProductName()
		{
				Scanner sc = new Scanner(System.in);
				String name;
				System.out.print("Enter a product name: ");
				name = sc.nextLine();
				while (name.isEmpty())
				{
						System.out.println("Sorry, product name can not empty. Try again");
						name = sc.nextLine();
				}
				this.productName = name;
		}

		public void setPrice()
		{
				Scanner sc = new Scanner(System.in);
				int num;
				do {
						System.out.print("Enter the price of product: ");
						while (!sc.hasNextInt()) {
								System.out.println("That not a number! Try again");
								sc.next();
						}
						num = sc.nextInt();
				} while (!(num >= 0) & !(num < 0));
				this.price = num;
		}
}
