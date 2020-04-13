var addressInit = function(_carea,_cmbProvince, _cmbCity, defaultarea1, defaultProvince, defaultCity)
{
    var area=document.getElementById(_carea);
    var cmbProvince = document.getElementById(_cmbProvince);
    var cmbCity = document.getElementById(_cmbCity);
    function cmbSelect(cmb, str)
    {
        for(var i=0; i<cmb.options.length; i++)
        {
            if(cmb.options[i].value == str)
            {
                cmb.selectedIndex = i;
                return;
            }
        }
    }
    function cmbAddOption(cmb, str, obj)
    {
        var option = document.createElement("OPTION");
        option.innerHTML = str;
        option.value = str;
        option.obj = obj;
        cmb.options.add(option);
    }
    function changeProvince()
    {
        cmbCity.options.length = 0;
        cmbCity.onchange = null;
        if(cmbProvince.selectedIndex == -1)return;

        var item = cmbProvince.options[cmbProvince.selectedIndex].obj;
        for(var i=0; i<item[cmbProvince.selectedIndex].cityList.length; i++)
        {
            cmbAddOption(cmbCity, item[cmbProvince.selectedIndex].cityList[i].name, item[cmbProvince.selectedIndex].cityList[i]);
        }
        cmbSelect(cmbCity, defaultCity);
    }
    function changeArea()
    {
        cmbProvince.options.length = 0;
        cmbProvince.onchange = null;
        if(area.selectedIndex == -1)return;
        var item=area.options[area.selectedIndex].obj;
        for(var i=0;i<item.Allcity.length;i++)
        {
            cmbAddOption(cmbProvince,item.Allcity[i].name,item.Allcity);
        }
        cmbSelect(cmbProvince,defaultProvince);
        changeProvince();
        cmbProvince.onchange=changeProvince;
    }




    for(var i=0; i<provinceList.length; i++)
    {
        cmbAddOption(area, provinceList[i]._area, provinceList[i]);
    }

    cmbSelect(area, defaultarea1);
    changeArea();
    area.onchange = changeArea;
}

var provinceList = [
    {_area:"1",Allcity:[

            {name:'1', cityList:[
                    {name:'1'},{name:'2'},{name:'3'},{name:'4'},{name:'5'},
                    {name:'6'},{name:'7'},{name:'8'},{name:'9'},{name:'10'},
                    {name:'11'},{name:'12'},{name:'13'},{name:'14'},{name:'15'},
                    {name:'16'},{name:'17'},{name:'18'},{name:'19'},{name:'20'},
                    {name:'21'},{name:'22'},{name:'23'},{name:'24'},{name:'25'},
                    {name:'26'},{name:'27'},{name:'28'},{name:'29'},{name:'30'},
                ]},
            {name:'2', cityList:[
                    {name:'1'},{name:'2'},{name:'3'},{name:'4'},{name:'5'},
                    {name:'6'},{name:'7'},{name:'8'},{name:'9'},{name:'10'},
                    {name:'11'},{name:'12'},{name:'13'},{name:'14'},{name:'15'},
                    {name:'16'},{name:'17'},{name:'18'},{name:'19'},{name:'20'},
                    {name:'21'},{name:'22'},{name:'23'},{name:'24'},{name:'25'},
                    {name:'26'},{name:'27'},{name:'28'},{name:'29'},{name:'30'},
                ]},
            {name:'3', cityList:[
                    {name:'1'},{name:'2'},{name:'3'},{name:'4'},{name:'5'},
                    {name:'6'},{name:'7'},{name:'8'},{name:'9'},{name:'10'},
                    {name:'11'},{name:'12'},{name:'13'},{name:'14'},{name:'15'},
                    {name:'16'},{name:'17'},{name:'18'},{name:'19'},{name:'20'},
                    {name:'21'},{name:'22'},{name:'23'},{name:'24'},{name:'25'},
                    {name:'26'},{name:'27'},{name:'28'},{name:'29'},{name:'30'},
                ]}
        ]
    },
    {_area:"2",Allcity:[

            {name:'1', cityList:[
                    {name:'1'},{name:'2'},{name:'3'},{name:'4'},{name:'5'},
                    {name:'6'},{name:'7'},{name:'8'},{name:'9'},{name:'10'},
                    {name:'11'},{name:'12'},{name:'13'},{name:'14'},{name:'15'},
                    {name:'16'},{name:'17'},{name:'18'},{name:'19'},{name:'20'},
                    {name:'21'},{name:'22'},{name:'23'},{name:'24'},{name:'25'},
                    {name:'26'},{name:'27'},{name:'28'},{name:'29'},{name:'30'},
                ]},
            {name:'2', cityList:[
                    {name:'1'},{name:'2'},{name:'3'},{name:'4'},{name:'5'},
                    {name:'6'},{name:'7'},{name:'8'},{name:'9'},{name:'10'},
                    {name:'11'},{name:'12'},{name:'13'},{name:'14'},{name:'15'},
                    {name:'16'},{name:'17'},{name:'18'},{name:'19'},{name:'20'},
                    {name:'21'},{name:'22'},{name:'23'},{name:'24'},{name:'25'},
                    {name:'26'},{name:'27'},{name:'28'},{name:'29'},{name:'30'},
                ]},
            {name:'3', cityList:[
                    {name:'1'},{name:'2'},{name:'3'},{name:'4'},{name:'5'},
                    {name:'6'},{name:'7'},{name:'8'},{name:'9'},{name:'10'},
                    {name:'11'},{name:'12'},{name:'13'},{name:'14'},{name:'15'},
                    {name:'16'},{name:'17'},{name:'18'},{name:'19'},{name:'20'},
                    {name:'21'},{name:'22'},{name:'23'},{name:'24'},{name:'25'},
                    {name:'26'},{name:'27'},{name:'28'},{name:'29'},{name:'30'},
                ]}
        ]
    },
    {_area:"3",Allcity:[

            {name:'1', cityList:[
                    {name:'1'},{name:'2'},{name:'3'},{name:'4'},{name:'5'},
                    {name:'6'},{name:'7'},{name:'8'},{name:'9'},{name:'10'},
                    {name:'11'},{name:'12'},{name:'13'},{name:'14'},{name:'15'},
                    {name:'16'},{name:'17'},{name:'18'},{name:'19'},{name:'20'},
                    {name:'21'},{name:'22'},{name:'23'},{name:'24'},{name:'25'},
                    {name:'26'},{name:'27'},{name:'28'},{name:'29'},{name:'30'},
                ]},
            {name:'2', cityList:[
                    {name:'1'},{name:'2'},{name:'3'},{name:'4'},{name:'5'},
                    {name:'6'},{name:'7'},{name:'8'},{name:'9'},{name:'10'},
                    {name:'11'},{name:'12'},{name:'13'},{name:'14'},{name:'15'},
                    {name:'16'},{name:'17'},{name:'18'},{name:'19'},{name:'20'},
                    {name:'21'},{name:'22'},{name:'23'},{name:'24'},{name:'25'},
                    {name:'26'},{name:'27'},{name:'28'},{name:'29'},{name:'30'},
                ]},
            {name:'3', cityList:[
                    {name:'1'},{name:'2'},{name:'3'},{name:'4'},{name:'5'},
                    {name:'6'},{name:'7'},{name:'8'},{name:'9'},{name:'10'},
                    {name:'11'},{name:'12'},{name:'13'},{name:'14'},{name:'15'},
                    {name:'16'},{name:'17'},{name:'18'},{name:'19'},{name:'20'},
                    {name:'21'},{name:'22'},{name:'23'},{name:'24'},{name:'25'},
                    {name:'26'},{name:'27'},{name:'28'},{name:'29'},{name:'30'},
                ]}
        ]
    },
    {_area:"4",Allcity:[

            {name:'1', cityList:[
                    {name:'1'},{name:'2'},{name:'3'},{name:'4'},{name:'5'},
                    {name:'6'},{name:'7'},{name:'8'},{name:'9'},{name:'10'},
                    {name:'11'},{name:'12'},{name:'13'},{name:'14'},{name:'15'},
                    {name:'16'},{name:'17'},{name:'18'},{name:'19'},{name:'20'},
                    {name:'21'},{name:'22'},{name:'23'},{name:'24'},{name:'25'},
                    {name:'26'},{name:'27'},{name:'28'},{name:'29'},{name:'30'},
                ]},
            {name:'2', cityList:[
                    {name:'1'},{name:'2'},{name:'3'},{name:'4'},{name:'5'},
                    {name:'6'},{name:'7'},{name:'8'},{name:'9'},{name:'10'},
                    {name:'11'},{name:'12'},{name:'13'},{name:'14'},{name:'15'},
                    {name:'16'},{name:'17'},{name:'18'},{name:'19'},{name:'20'},
                    {name:'21'},{name:'22'},{name:'23'},{name:'24'},{name:'25'},
                    {name:'26'},{name:'27'},{name:'28'},{name:'29'},{name:'30'},
                ]},
            {name:'3', cityList:[
                    {name:'1'},{name:'2'},{name:'3'},{name:'4'},{name:'5'},
                    {name:'6'},{name:'7'},{name:'8'},{name:'9'},{name:'10'},
                    {name:'11'},{name:'12'},{name:'13'},{name:'14'},{name:'15'},
                    {name:'16'},{name:'17'},{name:'18'},{name:'19'},{name:'20'},
                    {name:'21'},{name:'22'},{name:'23'},{name:'24'},{name:'25'},
                    {name:'26'},{name:'27'},{name:'28'},{name:'29'},{name:'30'},
                ]}
        ]
    },
    {_area:"自然拼读屋",Allcity:[

            {name:'1', cityList:[
                    {name:'A'},{name:'B'},{name:'C'},{name:'D'},{name:'E'},
                    {name:'F'},{name:'G'},{name:'H'},{name:'I'},{name:'J'},
                    {name:'K'},{name:'L'},{name:'M'},{name:'N'},{name:'O'},
                    {name:'P'},{name:'Q'},{name:'R'},{name:'S'},{name:'T'},
                    {name:'U'},{name:'V'},{name:'W'},{name:'X'},{name:'Y'},
                    {name:'Z'}
                ]},
            {name:'2', cityList:[
                    {name:'A'},{name:'B'},{name:'C'},{name:'D'},{name:'E'},
                    {name:'F'},{name:'G'},{name:'H'},{name:'I'},{name:'J'},
                    {name:'K'},{name:'L'},{name:'M'},{name:'N'},{name:'O'},
                    {name:'P'},{name:'Q'},{name:'R'},{name:'S'},{name:'T'},
                    {name:'U'},{name:'V'},{name:'W'},{name:'X'},{name:'Y'},
                    {name:'Z'}
                ]},
            {name:'3', cityList:[
                    {name:'A'},{name:'B'},{name:'C'},{name:'D'},{name:'E'},
                    {name:'F'},{name:'G'},{name:'H'},{name:'I'},{name:'J'},
                    {name:'K'},{name:'L'},{name:'M'},{name:'N'},{name:'O'},
                    {name:'P'},{name:'Q'},{name:'R'},{name:'S'},{name:'T'},
                    {name:'U'},{name:'V'},{name:'W'},{name:'X'},{name:'Y'},
                    {name:'Z'}
                ]}
        ]
    }
];