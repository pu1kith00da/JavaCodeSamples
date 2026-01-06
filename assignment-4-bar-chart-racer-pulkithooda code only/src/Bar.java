public class Bar implements Comparable<Bar> {
        protected String name;
        protected int value;
        protected String category;
        protected String label;



        // Creates a new bar. You do this.
        public Bar(String name, int value, String category, String label)
        {
            this.name=name;
            this.value=value;
            this.category=category;
            this.label=label;
        }
        public void setName(String name) {
                this.name = name;
        }

        public void setValue(int value) {
                this.value = value;
        }

        public void setCategory(String category) {
                this.category = category;
        }

        public void setLabel(String label) {
                this.label = label;
        }

        // Returns the name of this bar. You do this.
        public String getName()
        {
                return name;
        }

        // Returns the value of this bar.You do this.
        public int getValue()
        {
                return value;

        }

        // Returns the category of this bar. You do this.
        public String getCategory()
        {
                return category;
        }

        public String getLabel()
        {
                return label;
        }

        // Compare two bars by value. You do this.
        // Bar A is less than Bar B if the value of A is less than the value of B.
        // compareTo should return -1 if this < otherBar, 1 if this > otherBar, and 0 otherwise.
        // If otherBar is null, you should throw a NullPointerException.
        // if otherBar.name is null, or otherBar.value < 0, or otherBar.category is null, then throw an IllegalArgumentException.

        public int compareTo(Bar otherBar)
        {
               if(otherBar==null)
                {
                       throw new NullPointerException("Bar is null");
                }
                if (otherBar.name==null||otherBar.value<0||otherBar.category==null)
                {
                        throw new IllegalArgumentException("Either the name,value of category of the bar is incorrect");
                }
               if(this.value<otherBar.value)
               {
                       return -1;
               }
               else if (this.value>otherBar.value)
               {
                    return 1;
               }
               else
               {
                    return 0;
               }
        }
}
