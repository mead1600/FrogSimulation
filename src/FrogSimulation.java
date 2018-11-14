public class FrogSimulation {
    //Distance, in inches, from the starting position to the goal
    private int goalDistance;

    //Maximum number of hops allowed to reach the goal
    private int maxHops;

    public int[] testHops;
    public int nextHopIndex;

    /**
     *
     * @param dist
     * @param numHops
     */
    public FrogSimulation(int dist, int numHops)
    {
        goalDistance = dist;
        maxHops = numHops;
    }

    private int hopDistance()
    {
        int sign = 0;
        int distance = 0;
        double designate = Math.random();
        if(designate < 0.5)
        {
            sign = 1;
        }
        if(sign == 1)
        {
            distance = (int)(Math.random()*10);
        }
        else
        {
            distance = 0 - (int)(Math.random()*10);
        }
        return distance;
    }

    public boolean simulate()
    {
        int currentDist = 0;
        int currentHop = 0;
        while (currentHop < maxHops)
        {
            currentDist = currentDist + hopDistance();
            currentHop++;
        }
        if(currentDist >= goalDistance)
        {
            return true;
        }
        return false;
    }
    public double runSimulations(int num)
    {
        double attempts = 0;
        boolean simulation = false;
        for(int i = 0; i < num; i++)
        {
            simulation = simulate();
            if(simulation)
            {
                attempts++;
            }
        }
        return attempts;
    }
}
