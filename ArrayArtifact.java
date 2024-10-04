import java.util.Arrays;

public class ArtifactVault {
    private Artifact[] artifacts;
    private int size;

    // Constructor
    public ArtifactVault(int capacity) {
        artifacts = new Artifact[capacity];
        size = 0;
    }

    // Add an artifact to the first empty slot
    public void addArtifact(Artifact artifact) {
        if (size >= artifacts.length) {
            System.out.println("Vault is full! Cannot add artifact.");
            return;
        }
        artifacts[size] = artifact;
        size++;
        Arrays.sort(artifacts, 0, size); // Keep sorted by age
        System.out.println("Artifact added: " + artifact.getName());
    }

    // Remove an artifact by its name
    public boolean removeArtifact(String name) {
        for (int i = 0; i < size; i++) {
            if (artifacts[i].getName().equals(name)) {
                // Shift elements to the left
                for (int j = i; j < size - 1; j++) {
                    artifacts[j] = artifacts[j + 1];
                }
                artifacts[size - 1] = null; // Clear last slot
                size--;
                System.out.println("Artifact removed: " + name);
                return true;
            }
        }
        System.out.println("Artifact not found: " + name);
        return false;
    }

    // Find an artifact using linear search
    public Artifact linearSearch(String name) {
        for (int i = 0; i < size; i++) {
            if (artifacts[i].getName().equals(name)) {
                System.out.println("Artifact found using linear search: " + name);
                return artifacts[i];
            }
        }
        System.out.println("Artifact not found using linear search: " + name);
        return null;
    }

    // Find an artifact using binary search (array is sorted by artifact age)
    public Artifact binarySearch(String name) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (artifacts[mid].getName().equals(name)) {
                System.out.println("Artifact found using binary search: " + name);
                return artifacts[mid];
            }
            if (artifacts[mid].getName().compareTo(name) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Artifact not found using binary search: " + name);
        return null;
    }

    // Display all artifacts
    public void displayArtifacts() {
        System.out.println("Artifacts in the vault:");
        for (int i = 0; i < size; i++) {
            System.out.println(artifacts[i].getName() + " (Age: " + artifacts[i].getAge() + ")");
        }
    }

    // Inner class to represent Artifact
    public static class Artifact implements Comparable<Artifact> {
        private String name;
        private int age;

        public Artifact(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        // Compare artifacts by age (for sorting)
        @Override
        public int compareTo(Artifact other) {
            return Integer.compare(this.age, other.age);
        }
    }

    public static void main(String[] args) {
        ArtifactVault vault = new ArtifactVault(10);

        Artifact artifact1 = new Artifact("Ancient Vase", 200);
        Artifact artifact2 = new Artifact("Old Coin", 50);
        Artifact artifact3 = new Artifact("Sword", 500);
        Artifact artifact4 = new Artifact("Crown", 1000);

        vault.addArtifact(artifact1);
        vault.addArtifact(artifact2);
        vault.addArtifact(artifact3);
        vault.addArtifact(artifact4);

        vault.displayArtifacts();

        vault.linearSearch("Old Coin");
        vault.binarySearch("Sword");

        vault.removeArtifact("Crown");
        vault.displayArtifacts();
    }
}
