namespace NUnitExample;

public class Tests
{
    [SetUp]
    public void Setup()
    {
        Console.WriteLine("Setting Up");
    }

    [Test]
    public void Test1()
    {
        Assert.Pass();
    }
}