import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Marketplace
{
		private static ArrayList<User> lisfOfUsers = new ArrayList<>();
		private static ArrayList<Product> lisfOfProducts = new ArrayList<>();
		public static void main(String[] args)
		{
				Scanner console = new Scanner(System.in);
				System.out.println("Welcome to marketplace v0.1!\n");
				int value = 0;

				do
				{
						textMenu();
						do {
								while (!console.hasNextInt()) {
										System.out.println("That not a number! Try again");
										console.next();
								}
								value = console.nextInt();
						} while (!(value >= 0) & !(value < 0));

						workOut(value);

						System.out.println();
				} while(value != 9);

		}

		private static void workOut(int num)
		{
				Scanner console = new Scanner(System.in);
				switch (num)
				{
						case 1:
						{
								lisfOfUsers.add(new User());
								break;
						}
						case 2:
						{
								lisfOfProducts.add(new Product());
								break;
						}
						case 3:
						{
								int inputIdUser;
								try
								{
										System.out.print("Enter the user's id: ");
										inputIdUser = console.nextInt();
										User.deleteUser(lisfOfUsers, inputIdUser);
								}
								catch(InputMismatchException e)
								{
										e.printStackTrace();
										System.out.println("Input mismatch exception. Try again");
										console.next();
								}
								break;
						}
						case 4:
						{
								int inputIdProduct;
								try
								{
										System.out.print("Enter the product's id: ");
										inputIdProduct = console.nextInt();
										Product.deleteProduct(lisfOfProducts, inputIdProduct);
								}
								catch(InputMismatchException e)
								{
										e.printStackTrace();
										System.out.println("Input mismatch exception. Try again");
										console.next();
								}
								break;
						}
						case 5:
						{
								if(lisfOfUsers.size() > 0)
								{
										for(User element: lisfOfUsers)
												element.getTextInfoAboutUser();
								}
								else
								{
										System.out.println("Add someone to the list of users");
								}
								break;
						}
						case 6:
						{
								if(lisfOfProducts.size() > 0)
								{
										for(Product element: lisfOfProducts)
												element.getTextInfoAboutProduct();
								}
								else
								{
										System.out.println("Add something to the list of products");
								}
								break;
						}
						case 7:
						{
								if (lisfOfUsers.size() > 0 & lisfOfProducts.size() > 0)
								{
									int idProduct;
									int idUser;
									boolean check = false;
									try
									{
											System.out.print("Enter user's id for purchase: ");
											idUser = console.nextInt();
											System.out.print("Enter product's id for sale: ");
											idProduct = console.nextInt();

											for(User element: lisfOfUsers)
											{
													if (element.getID() == idUser)
													{
															check = true;
															element.buyProduct(lisfOfProducts,idProduct);
															break;
													}
											}
										if(!check) System.out.println("User not found");
									}
									catch (InputMismatchException e)
									{
											e.printStackTrace();
											System.out.println("Input mismatch exception. Try again");
											console.next();
									}
								}
								else
								{
										System.out.println("The list of users and products have to lots of one value");
								}
								break;
						}
						case 8:
						{
								if (lisfOfUsers.size() > 0 & lisfOfProducts.size() > 0)
								{
										int idUser;
										boolean check = false;
										try
										{
												System.out.print("Enter user's id: ");
												idUser = console.nextInt();

												for(User element: lisfOfUsers)
												{
														if (element.getID() == idUser)
														{
																check = true;
																element.getTextListOfPurchases();
																break;
														}
												}
												if(!check) System.out.println("User not found");
										}
										catch (InputMismatchException e)
										{
												e.printStackTrace();
												System.out.println("Input mismatch exception. Try again");
												console.next();
										}
								}
								else
								{
										System.out.println("The list of users and products have to lots of one value");
								}
								break;
						}
						case 9:
								break;
						default:
								System.out.println("You entered incorrect value");
								break;
				}
		}

		private static void textMenu()
		{
				System.out.println("Click 1: To add a user");
				System.out.println("Click 2: To add a product");
				System.out.println("Click 3: Delete user from the list");
				System.out.println("Click 4: Delete product from the list");
				System.out.println("Click 5: Show full list of users");
				System.out.println("Click 6: Show full list of products");
				System.out.println("Click 7: Make a purchase");
				System.out.println("Click 8: Show the list of user's purchases");
				System.out.println("Click 9: Exit the program");
				System.out.print("Your answer: ");
		}


}