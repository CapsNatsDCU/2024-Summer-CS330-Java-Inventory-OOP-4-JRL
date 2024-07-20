package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
import edu.odu.cs.cs330.items.Tool;
import edu.odu.cs.cs330.items.Consumable;


@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ConsumableCreation implements ItemCreationStrategy
{
    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "construct" since "new" is a reserved keyword in Java.
     */
    public static ConsumableCreation construct()
    {
        return new ConsumableCreation();
    }

    @Override
    public Item fromDefaults()
    {
        Consumable neo = new Consumable();
        neo.setName("[Placeholder]");
        return neo;
    }

    @Override
    public int requiredNumberOfValues()
    {
        // Replace the return value;
        return 3;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens)
    {
        Consumable joey = new Consumable();

        joey.setName(tokens[0]);
        joey.setEffect(tokens[1]);
        joey.setNumberOfUses(Integer.parseInt(tokens[2]));

        return joey;
    }

    @Override
    public Item fromExisting(final Item original)
    {
        Consumable neo = new Consumable();
        Consumable oldConsumable = (Consumable) original;
        neo.setName(oldConsumable.getName());
        neo.setEffect(oldConsumable.getEffect());
        neo.setNumberOfUses(oldConsumable.getNumberOfUses());
        return neo;
    }
}
