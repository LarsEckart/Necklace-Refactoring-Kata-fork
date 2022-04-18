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

    public static String printWithContent(JewelleryStorage storage) {
        return "%s %s %s %s %s %s %s".formatted(
                storage.travelRoll.isEmpty() ? "" : "travel roll: " + storage.travelRoll.get(0),
                storage.box.mainSection.isEmpty() ? "" : "box main: " + storage.box.mainSection.get(0),
                storage.box.topShelf.isEmpty() ? "" : "box top shelf: " + storage.box.topShelf.get(0),
                storage.box.ringCompartment.isEmpty() ? "" : "box ring compartment: " + storage.box.ringCompartment.get(0),
                storage.dresserTop.isEmpty() ? "" : "dresser top: " + storage.dresserTop.get(0),
                storage.safe.isEmpty() ? "" : "safe: " + storage.safe.get(0),
                storage.tree.isEmpty() ? "" : "tree: " + storage.tree.get(0)
        ).strip();
    }
}
