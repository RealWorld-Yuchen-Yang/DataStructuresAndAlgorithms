package interviewquestions;

public class ReferenceReplication
{
	public static void main(String[] args)
	{
		Apple myApple = new Apple("Green");
		Apple.dispose(myApple);
		System.out.println(myApple.getColor());
	}
	
	static class Apple
	{
		private String color;
		
		Apple(String color)
		{
			this.color = color;
		}
		
		public static void dispose(Apple apple)
		{
			apple = null;
		}
		
		public String getColor()
		{
			return color;
		}
	}
}
