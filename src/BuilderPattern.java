import lombok.ToString;

@ToString
class Teacher {
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private Teacher(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
    }



    public static class Builder {
        private Integer id;
        private String name;
        private String email;
        private String phoneNumber;



        public Builder id(Integer id){
            this.id = id;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Teacher build(){
            return new Teacher(this);
        }
    }
}


public class BuilderPattern {
    static void main(String[] args) {


        Teacher teacher = new Teacher.Builder()
                .id(1)
                .name("Ratana")
                .build();


        System.out.println(teacher);
    }
}
