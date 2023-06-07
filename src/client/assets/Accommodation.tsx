class Accommodation {
    id: string;
    name: string;
    pictures: [string];
    price: number;
    rating: number;
    numberOfReviews: number;
    location: string;
    description: string;
    startDate: Date;
    endDate: Date;
    isFavorite: boolean = false;
    profile: ProfilEmbedded;

    constructor(
        id: string,
        name: string,
        pictures: [string],
        price: number,
        rating: number,
        numberOfReviews: number,
        location: string,
        description: string,
        startDate: Date,
        endDate: Date,
        isFavorite: boolean,
        profile: ProfilEmbedded
    ) {
        this.id = id;
        this.name = name;
        this.pictures = pictures;
        this.price = price;
        this.rating = rating;
        this.numberOfReviews = numberOfReviews;
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isFavorite = isFavorite;
        this.profile = profile;
    }
}