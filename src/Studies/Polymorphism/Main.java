package Studies.Polymorphism;

/**
 * Created by CAD5124 on 12/29/2016.
 */
class Movie
{
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot()
    {
        return "No plot here";
    }

    public String getName(){
        return name;
    }
}

class Jaws extends Movie
{
    public Jaws()
    {
        super("Jaws");
    }

    @Override
    public String plot(){ //Overrides Movie.plot()
        return "A shark eats lots of people";
    }
}

class IndependanceDay extends Movie{
    public IndependanceDay(){
        super("Independance Day");
    }

    @Override
    public String plot(){
        return "Aliens attempt to take over Earth";
    }
}

class MazeRunner extends Movie{
    public MazeRunner(){
        super("Maze Runner");
    }

    @Override
    public String plot(){
        return "Kids try to escape a maze";
    }
}

class StarWars extends Movie{
    public StarWars(){
        super("Star Wars");
    }

    @Override
    public String plot(){
        return "Imperial Forces try to take over the universe";
    }
}

class Forgetable extends Movie{
    public Forgetable(){
        super("Forgetable");
    }

    // No plot
}

public class Main
{
    public static void main(String[] args)
    {
        for(int i = 1; i < 11; i++){
            Movie movie = randomMovie();
            System.out.println("Move #" + i + " : " + movie.getName()
            + "\n" + "Plot: " + movie.plot() + "\n");
        }
    }

    public static Movie randomMovie(){
        int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("Random Number was " + randomNumber);
        switch(randomNumber){
            case 1:
                return new Jaws();
            case 2:
                return new IndependanceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new Forgetable();
        }
        return null;
    }
}