# MiddleMan
##### A Better way to handle items in the Simple list and Paged list in RecyclerView.

Middleman is a library for helping handling items in recyclerView adapters with better following SOLID rules.     
it supports both simple list and paging list in recyclerView.      
    
[ ![Download](https://api.bintray.com/packages/mohamad-khaleghy/MiddleMan/MiddleMan/images/download.svg) ](https://bintray.com/mohamad-khaleghy/MiddleMan/MiddleMan/_latestVersion)

### why use Middleman?
[you can find out here.][1]


### Gradle
    implementation "com.mohamadk:middleman:{last-version}"
    

    allprojects {
        repositories {
            google()
            jcenter()
            
            maven {
                    url  "https://dl.bintray.com/mohamad-khaleghy/MiddleMan"
                  }
        }
    }

### How to use it

1- create an instance of GeneralViewAdapter and set it to recyclerView 

     recyclerView.apply {

            adapter = GeneralViewAdapter(this@SampleListFragment)
            // or for support paging in your list
            adapter = GeneralPagingViewAdapter(this@SampleListFragment)
            
            layoutManager = LinearLayoutManager(activity)
        }

2- implement BaseModel in every item model.
implement defaultResLayout or defaultViewClass method.    
you can declare a reslayout or a class of your customView item.     

    @Parcelize
    class ItemModel(val id:String,val name:String):BaseModel{
        override fun defaultResLayout(position: Int): Int? {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    
        override fun defaultViewClass(position: Int): Class<*>? {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    
    }
    
3- create a customView for each item in your recycler view that 
implement Binder interface and if need to interact with 
activity or fragment implement the corresponding interactor.     

    open class ItemView @JvmOverloads constructor(
        context: Context,
        attributes: AttributeSet? = null,
        defStyleAttributes: Int = 0
    ) : LinearLayoutCompat(context, attributes, defStyleAttributes)
        , Binder<ItemModel>
        , RequireInteractor<SomeIntractor> {
    
        private lateinit var someIntractor: SomeIntractor
    
        override fun setInteractor(intractor: SomeIntractor) {
            this.someIntractor = intractor
        }
    
        override fun bind(item: ItemModel?) {
            ....
        }
    }
 
 and that's it.

[1]: https://medium.com/@MohamadKhaleghy/middleman-e9e26c0fe4a4