package necklaceRefactoringKata;

public class StoragePrinter {
    public static String print(JewelleryStorage storage) {
        return "%s %s %s %s %s %s %s".formatted(
                storage.travelRoll.isEmpty() ? "" : "travel roll",
                storage.box.mainSection.isEmpty() ? "" : "box main",
                storage.box.topShelf.isEmpty() ? "" : "box top shelf",
                storage.box.ringCompartment.isEmpty() ? "" : "box ring compartment",
                storage.dresserTop.isEmpty() ? "" : "dresser top",
                storage.safe.isEmpty() ? "" : "safe",
                storage.tree.isEmpty() ? "" : "tree"
        ).strip();
    }
}
