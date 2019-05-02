# MiddleMan
##### A Better way to handle items in the Simple list and Paged list in RecyclerView.

Middleman is a library for helping handling items in recyclerView adapters with better following SOLID rules.     
it supports both simple list and paging list in recyclerView.      
    
[ ![Download](https://api.bintray.com/packages/mohamad-khaleghy/MiddleMan/MiddleMan/images/download.svg) ](https://bintray.com/mohamad-khaleghy/MiddleMan/MiddleMan/_latestVersion)

### why use Middleman?
Recyclerview Mess:
In almost all mobile applications there is a need for at least one page that shows a list of items it might be a list of
 products, contacts messages,...
In big projects like e-commerce applications when you have a lot of different items in a list and a lot of list pages it
kind of becomes a big problem when you want to add a new item in Recyclerview you have to create new Viewholder then
change your adapter to handling that kind of the
view and what if your new item needed to talk to fragment then you have to change more in your adapter, what if you want
to use this new item in other Recyclerviews in other pages? a lot of things to do right.

[you can find out more here.][1]


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