class Author {
    private Integer id;
    private String uuid;
    private String name;
    private String profile;
    private String dateOfBirth;



    public Author(Builder builder){
        this.id = builder.id;
        this.uuid = builder.uuid;
        this.name = builder.name;
        this.profile = builder.profile;
        this.dateOfBirth = builder.dateOfBirth;

    }


    public static class Builder {
        private Integer id;
        private String uuid;
        private String name;
        private String profile;
        private String dateOfBirth;


        public Builder id(Integer id){
            this.id = id;
            return this;
        }

        public Builder uuid(String uuid){
            this.uuid = uuid;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder profile(String profile){
            this.profile = profile;
            return this;
        }


        public Builder dateOfBirth(String dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Author build(){
            return new Author(this);
        }

    }

}


class Movie {
    private Integer id;
    private String uuid;
    private String title;
    private String description;


    public Movie (Builder builder){
        this.id = builder.id;
        this.uuid = builder.uuid;
        this.title = builder.title;
        this.description = builder.description;
    }



    public static class Builder{
        private Integer id;
        private String uuid;
        private String title;
        private String description;


        public Builder id(Integer id){
            this.id = id;
            return this;
        }

        public Builder uuid(String uuid){
            this.uuid = uuid;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Movie build(){
            return new Movie(this);
        }
    }




}



public class Practice {
    static void main(String[] args) {



        Author author = new Author.Builder()
                .id(1)
                .name("Ot dg muy na te")
                .build();


        Movie movie = new Movie.Builder()
                .id(1)
                .build();

        System.out.println(movie);

        System.out.println(author);
    }
}
