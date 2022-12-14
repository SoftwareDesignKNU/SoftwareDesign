import kotlin.test.Test
import kotlin.test.assertTrue
 

class TestUC {
    //T1 - UC7 - SDA1 Basic scenario
    @Test
    fun TestLoginBasic() {
        reduce(LoginButtonClickLoginEven())
        println("reduce: reduce branch visited")
        println("reduce: nvoked by Zotero User")
        login(User("Username","password"))
        print("login: login branch visited")
        print("login: invoked by LoginComponent")

    }

    //T1.2 - UC7 - SDA1 Alternate scenario
    @Test
    fun TestLoginAlternate(){
        
    }

    //T2 - UC3 - SDA2 Basic Scenario
    @Test
    fun TestCreateCollectionBasic(){
        
    }

    //T2.2 - UC3 - SDA2 Alternate Scenario
    @Test
    fun TestCreateCollectionAlternate(){
        
    }
    //T3 - UC5 - SDA3 Basic Scenario
    @Test
    fun DeleteCollectionBasic(){
        
    }

    //T3.2 - UC5 - SDA3 Alternate
    @Test
    fun TestDeleteCollectionBasic(){
        
     }
    
    //T4 - UC4 - SDA4 Basic Scenario
    @Test
    fun TestDeleteItemsBasic(){
        
    }

    //T4.2 - UC4 - SDA4 Alternate Scenario
    @Test
    fun TestDeleteItemsAlternate(){
        
    }

    //T5 - UC9 - SDA5 Basic Scenario
    @Test
    fun TestAdvancedSearchBasic(){
        
    }

     //T5.2 - UC9 - SDA5 Alternate Scenario
    @Test
    fun TestAdvancedSearchAlternate(){
        
    }

    //T6 - UC12 - SDA6 Basic Scenario
    @Test
    fun TestGenerateCitationBasic(){
        
    }
    //T6.2 - UC12 - SDA6 Alternate Scenario
    @Test
    fun TestGenerateCitationAlternate(){
        
    }

    //T7 - UC1 - SDA7 Basic 
    @Test
    fun TestAddItemBasic(){
        
    }

    //T7.2 - UC1 - SDA7 Alternate Scenario
    @Test
    fun TestAddItemAlternate(){
        
     }

    //T8 - UC10 - SDA8 Basic Scenario
    @Test
    fun TestQuickSearchBasic(){
        
    }

    //T8.2 - UC10 - SDA8 Alternate Scenario
    @Test
    fun TestQuickSearchAlternate(){
        
    }

    //T9 - UC2 - SDA9 Basic Scenario
    @Test
    fun TestUpdateItemsBasic(){
        
    }

    //T9.2 - UC2 - SDA9 Alternate Scenario
    @Test
    fun TestUpdateItemsAlternate(){
        
    }
    //T10 - UC6 - SDA10 Basic Scenario
    @Test
    fun TestRegisterBasic(){
        
    }

    //T10.2 - UC6 - SDA10 Alternate Scenario
    @Test
    fun TestRegisterAlternate(){
        
    }

    //T11 - UC8 - SDA11 Basic Scenario
    @Test
    fun TestResetPasswordBasic(){
        
    }
    //T11.2 - UC8 - SDA11 Alternate Scenario
    @Test
    fun TestResetPasswordAlternate(){
        
    }

    //T12 - UC12 - SDA12 
    @Test
    fun TestSyncLibrary(){
        
    }

    //T13 - UC11 - SDA13 Basic Scenario 
    @Test
    fun TestAddItemsAutoBasic(){
        
    }

    //T13.2 - UC11 - SDA13 Alternate Scenario 
    @Test
    fun TestAddItemsAutoAlternate(){
        
    }



}

