import java.util.ArrayList;
import java.util.Scanner;

public class User
{
		private static int ID = 1;
		private int idUsers;
		private String firstName;
		private String lastName;
		private int amountOfMoney;
		private ArrayList<Product> userPurchases;

		public User()
		{
				this.idUsers = ID;
				setFirstName();
				setLastName();
				setAmountOfMoney();
				this.userPurchases = new ArrayList<>();
				ID++;
		}

		public static void deleteUser(ArrayList<User> list, int ID)
		{
				int size = list.size();
				if(size < 1) System.out.println("The list of users is empty");
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

		public void buyProduct(ArrayList<Product> list, int id)
		{
				boolean check = false;
				int userMoney = this.getAmountOfMoney();
				int productPrice = 0;
				int index = 0;
				if (list.size() < 1) System.out.println("The list of products is empty");
				else
				{
						for (int i = 0; i < list.size(); i++)
						{
								if(list.get(i).getID() == id)
								{
										check = true;
										index = i;
										productPrice = list.get(i).getPrice();
								}
						}
						if(!check) System.out.println("There is not product in list");
						else
						{
							if (productPrice <= userMoney)
							{
									this.amountOfMoney -=productPrice;
									this.userPurchases.add(list.get(index));
									System.out.println("Purchases added");
							}
							else
							{
									System.out.println("User has little money");
							}
						}
				}
		}

		public void getTextInfoAboutUser()
		{
				System.out.println("ID: " + this.idUsers + "; Name: " + this.firstName + "; Last name: " + this.lastName +
												"; Amount of money: " + this.amountOfMoney);
		}

		public void getTextListOfPurchases()
		{
				if(this.userPurchases.size() > 0)
				{
						for (Product element: userPurchases)
								element.getTextInfoAboutProduct();
				}
				else
				{
						System.out.println("The list of purchases is empty");
				}
		}

		public void setFirstName()
		{
				Scanner sc = new Scanner(System.in);
				String name;
				System.out.print("Enter a name: ");
				name = sc.nextLine();
				while (name.isEmpty())
				{
						System.out.println("Sorry, name can not empty. Try again");
						name = sc.nextLine();
				}
				this.firstName = name;
		}

		public void setLastName()
		{
				Scanner sc = new Scanner(System.in);
				String name;
				System.out.print("Enter a last name: ");
				name = sc.nextLine();
				while (name.isEmpty())
				{
						System.out.println("Sorry, but last name can not empty. Try again");
						name = sc.nextLine();
				}
				this.lastName = name;
		}

		public void setAmountOfMoney()
		{
				Scanner sc = new Scanner(System.in);
				int num;
				do {
						System.out.print("Enter amount of money: ");
						while (!sc.hasNextInt()) {
								System.out.println("That not a number! Try again");
								sc.next();
						}
						num = sc.nextInt();
				} while (!(num >= 0) & !(num < 0));
			 this.amountOfMoney = num;
		}

	public int getID()
	{
			return this.idUsers;
	}

	public int getAmountOfMoney()
	{
			return this.amountOfMoney;
	}


}
