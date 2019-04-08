# NY Times Article Sample
Created By DeepK Tyagi
Purely a sample project for demostration purpose
 
 ## Installation
 • I have include a .Zip file and debug version of the app (.apk) within code structure  
    o	Inflate the Zip folder and open the project in Android Studio		
		
    o	Connect any android phone having suitable driver available on laptop. Create one AVD having 23+ API support.
		  You should be able to run the app directly from Studio
   
	 OR
	 
	o	Transfer the .APK on android phone.
	
	o	Allow “Install from Unknown Source” option and install this APK
	
	o	You should see an icon “NY Times Article” on phone home screen	

## Object oriented programming approach- MVVM	
	
		Model Classes: /com.deep.nytimesarticles/Models	
			•	ArticlesModel
				o	Class represents the POJO structure of JSON object returned by source API
			•	Result: Generic List Collection Object containing the list of articles from Source API
				o	private int numResults;
						@SerializedName("results")
						@Expose
						private List<Result> results = null;
	
			View : /com.deep.nytimesarticles/
				•	MainActivity

			ViewModel
				•	ArticleViewModel
					o	Mutable Live Data Property –  articlesList
					o	LiveData/Observable Method – getArticles
					o	Member Function to load the data using Retrofit Library – LoadArticles()

# Screen Shots
![alt text](https://user-images.githubusercontent.com/6625843/55723860-b47fa780-5a27-11e9-8b5b-09b8d96272d1.PNG)
![alt text](https://user-images.githubusercontent.com/6625843/55723861-b47fa780-5a27-11e9-9983-70790d4021cb.PNG)

		
	
