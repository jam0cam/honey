<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<c:set var="pageTitle" value="Original Tai Chi Style: Movement & Unique Form Counts" scope="request"/>
<jsp:include page="includes/header.jsp"/>
<style>
    .table th,
    .table td {
        text-align: center;
    }

    #intermediate
    {
        color: green;
    }

    #advanced1
    {
        color: blue;
    }

    #advanced2
    {
       color: purple;
    }
</style>
<form:form class="form-taichi" commandName="command">
    <h3 class="text-center">Original Tai Chi Style: Movement & Unique Form Counts</h3>
    <h3 class="text-center">吳氏太極拳</h3>
    <hr>
    <br><br>

    <table class="table table-bordered" style="width: 700px; word-wrap: normal;">
        <thead>
        <tr>
            <th>Form</th>
            <th>Description</th>
            <th style="width: 100px;">Unique Form</th>
            <th style="width: 100px;">Number of Movements</th>
            <th style="width: 100px;">Cumulative Movements</th>
        </tr>
        </thead>
        <tr>
            <td><b>BEGINNING</b></td><td></td><td></td><td></td><td></td>
        </tr>
        <tr>
            <td>1</td>
            <td>Tai Chi Preparation<br>預備式</td>
            <td>1</td><td>4</td><td>4</td>
        </tr>
        <tr>
            <td>2</td>
            <td>Starting Tai Chi<br>太極起式</td>
            <td>1</td><td>6</td><td>10</td>
        </tr>
        <tr>
            <td>3</td>
            <td>Grasping Bird's Tail<br>攬雀尾</td>
            <td>1</td><td>8</td><td>18</td>
        </tr>
        <tr>
            <td>4</td>
            <td>Single Whip<br>單鞭</td>
            <td>1</td><td>1</td><td>19</td>
        </tr>
        <tr>
            <td>5</td>
            <td>Upward Arm Elevation<br>提手上勢</td>
            <td>1</td><td>5</td><td>24</td>
        </tr>
        <tr>
            <td>6</td>
            <td>White Crane Spreading Wing<br>白鶴亮翅</td>
            <td>1</td><td>4</td><td>28</td>
        </tr>
        <tr>
            <td>7</td>
            <td>Left Forward Step<br>左摟膝抝步</td>
            <td>1</td><td>5</td><td>33</td>
        </tr>
        <tr>
            <td>8</td>
            <td>Right Forward Step<br>右摟膝抝步</td>
            <td>1</td><td>3</td><td>36</td>
        </tr>
        <tr>
            <td>9</td>
            <td>Left Forward Step<br>左摟膝抝步</td>
            <td>1</td><td>3</td><td>39</td>
        </tr>
        <tr>
            <td>10</td>
            <td>Hand Playing the Lute<br>手揮琵琶</td>
            <td>1</td><td>4</td><td>43</td>
        </tr>
        <tr>
            <td>11</td>
            <td>Forward Block Punch<br>搬瓓捶</td>
            <td>1</td><td>4</td><td>47</td>
        </tr>
        <tr>
            <td>12</td>
            <td>Retreating Forward Push<br>如封似閉</td>
            <td>1</td><td>6</td><td>53</td>
        </tr>

        <tr style="font-weight: bold;">
            <td></td>
            <td style="text-align: right;">Total for Forms 1-12</td>
            <td>12</td><td>53</td><td></td>
        </tr>
        <tbody id="intermediate">
        <tr>
            <td><b>INTERMEDIATE</b></td><td></td><td></td><td></td><td></td>
        </tr>
        <tr>
            <td>13</td>
            <td>Cross Block<br>十字手</td>
            <td>1</td><td>4</td><td>57</td>
        </tr>
        <tr>
            <td>14</td>
            <td>Returning Tiger to Mountain<br>抱虎歸山</td>
            <td>1</td><td>6</td><td>63</td>
        </tr>
        <tr>
            <td>15</td>
            <td>Grasping Bird's Tail<br>攬雀尾(斜)</td>
            <td>1</td><td>8</td><td>71</td>
        </tr>
        <tr>
            <td>16</td>
            <td>Oblique Single Whip<br>斜單鞭</td>
            <td>1</td><td>1</td><td>72</td>
        </tr>
        <tr>
            <td>17</td>
            <td>Forming Fist Under Elbow<br>肘底看捶</td>
            <td>1</td><td>3</td><td>75</td>
        </tr>
        <tr>
            <td>18</td>
            <td>Reversed Right Forward Step<br>左倒攆猴</td>
            <td>1</td><td>2</td><td>77</td>
        </tr>
        <tr>
            <td>19</td>
            <td>Reversed Left Forward Step<br>右倒攆猴</td>
            <td>1</td><td>2</td><td>79</td>
        </tr>
        <tr>
            <td>20</td>
            <td>Reversed Right Forward Step<br>左倒攆猴</td>
            <td></td><td>2</td><td>81</td>
        </tr>
        <tr>
            <td>21</td>
            <td>Oblique Arm Glide<br>斜飛勢</td>
            <td>1</td><td>3</td><td>84</td>
        </tr>
        <tr>
            <td>22</td>
            <td>Upward Arm Elevation<br>提手上勢</td>
            <td></td><td>4</td><td>88</td>
        </tr>
        <tr>
            <td>23</td>
            <td>White Crane Spreading Wing<br>白鶴亮翅</td>
            <td></td><td>4</td><td>92</td>
        </tr>
        <tr>
            <td>24</td>
            <td>Left Forward Step<br>摟膝抝步(左)</td>
            <td></td><td>3</td><td>95</td>
        </tr>
        <tr>
            <td>25</td>
            <td>Sea Bottom Plunge<br>海底針</td>
            <td>1</td><td>3</td><td>98</td>
        </tr>
        <tr>
            <td>26</td>
            <td>Fan Through Tunnel<br>扇通背</td>
            <td>1</td><td>3</td><td>101</td>
        </tr>
        <tr>
            <td>27</td>
            <td>Turning Over Punch<br>撇身捶</td>
            <td>1</td><td>2</td><td>103</td>
        </tr>
        <tr>
            <td>28</td>
            <td>Retreating Block Punch<br>退步搬瓓捶</td>
            <td>1</td><td>4</td><td>107</td>
        </tr>
        <tr>
            <td>29</td>
            <td>Grasping Bird's Tail Forward<br>上步攬雀尾</td>
            <td>1</td><td>7</td><td>114</td>
        </tr>
        <tr>
            <td>30</td>
            <td>Single Whip<br>單鞭</td>
            <td></td><td>1</td><td>115</td>
        </tr>
        <tr>
            <td>31</td>
            <td>Cloud Hand One<br>雲手一</td>
            <td>1</td><td>2</td><td>117</td>
        </tr>
        <tr>
            <td>32</td>
            <td>Cloud Hand Two<br>雲手二</td>
            <td>1</td><td>4</td><td>121</td>
        </tr>
        <tr>
            <td>33</td>
            <td>Cloud Hand Three<br>雲手三</td>
            <td></td><td>4</td><td>125</td>
        </tr>
        <tr>
            <td>34</td>
            <td>Single Whip<br>單鞭</td>
            <td></td><td>2</td><td>127</td>
        </tr>
        <tr style="font-weight: bold;">
            <td></td>
            <td style="text-align: right;">Total for Forms 13-34</td>
            <td>15</td><td>74</td><td></td>
        </tr>
        <tr style="font-weight: bold;">
            <td></td>
            <td style="text-align: right;">Total for Forms 1-34</td>
            <td>27</td><td>127</td><td></td>
        </tr>
        </tbody>
        <tbody id="advanced1">
        <tr>
            <td><b>ADVANCED(I)</b></td><td></td><td></td><td></td><td></td>
        </tr>
        <tr>
            <td>35</td>
            <td>Left Side Block<br>左高探馬</td>
            <td>1</td><td>2</td><td>129</td>
        </tr>
        <tr>
            <td>36</td>
            <td>Right Split Kick<br>左右分腳(右)</td>
            <td>1</td><td>2</td><td>131</td>
        </tr>
        <tr>
            <td>37</td>
            <td>Right Side Block<br>右高探馬</td>
            <td>1</td><td>1</td><td>132</td>
        </tr>
        <tr>
            <td>38</td>
            <td>Left Split Kick<br>左右分腳(左)</td>
            <td>1</td><td>2</td><td>134</td>
        </tr>
        <tr>
            <td>39</td>
            <td>Turning Left Push Kick<br>轉身蹬腳</td>
            <td>1</td><td>3</td><td>137</td>
        </tr>
        <tr>
            <td>40</td>
            <td>Left Forward Step<br>左摟膝抝步</td>
            <td>1</td><td>1</td><td>138</td>
        </tr>
        <tr>
            <td>41</td>
            <td>Right Forward Step<br>右摟膝抝步</td>
            <td></td><td>3</td><td>141</td>
        </tr>
        <tr>
            <td>42</td>
            <td>Advancing Downward Punch<br>進步載捶</td>
            <td>1</td><td>3</td><td>144</td>
        </tr>
        <tr>
            <td>43</td>
            <td>Turn-Around Over Punch<br>翻身撇身捶</td>
            <td>1</td><td>2</td><td>146</td>
        </tr>
        <tr>
            <td>44</td>
            <td>Step-Up Left Side Block<br>上步高探馬(左)</td>
            <td>1</td><td>1</td><td>147</td>
        </tr>
        <tr>
            <td>45</td>
            <td>Right Split Kick<br>披身踢腳</td>
            <td></td><td>2</td><td>149</td>
        </tr>
        <tr>
            <td>46</td>
            <td>Retreating Tiger Punch<br>退步打虎</td>
            <td>1</td><td>4</td><td>153</td>
        </tr>
        <tr>
            <td>47</td>
            <td>Right Side Kick<br>二起腳</td>
            <td>1</td><td>1</td><td>154</td>
        </tr>
        <tr>
            <td>48</td>
            <td>Double Fist Ear Punch<br>雙峯貫耳</td>
            <td>1</td><td>2</td><td>156</td>
        </tr>
        <tr>
            <td>49</td>
            <td>Left Pivot Split Kick<br>翻身二起腳之一</td>
            <td>1</td><td>2</td><td>158</td>
        </tr>
        <tr>
            <td>50</td>
            <td>Right Pivot Split Kick<br>翻身二起腳之二</td>
            <td>1</td><td>4</td><td>162</td>
        </tr>
        <tr>
            <td>51</td>
            <td>Over Punch<br>撇身捶</td>
            <td>1</td><td>1</td><td>163</td>
        </tr>
        <tr>
            <td>52</td>
            <td>Advancing Block Punch<br>上步搬瓓捶</td>
            <td>1</td><td>4</td><td>167</td>
        </tr>
        <tr>
            <td>53</td>
            <td>Retreating Forward Push<br>如封似閉</td>
            <td></td><td>6</td><td>173</td>
        </tr>
        <tr>
            <td>54</td>
            <td>Cross Block<br>十字手</td>
            <td></td><td>4</td><td>177</td>
        </tr>

        <tr>
            <td>55</td>
            <td>Returning Tiger to Mountain<br>抱虎歸山</td>
            <td></td><td>6</td><td>183</td>
        </tr>
        <tr>
            <td>56</td>
            <td>Grasping Bird's Tail<br>攬雀尾(斜)</td>
            <td></td><td>8</td><td>191</td>
        </tr>
        <tr>
            <td>57</td>
            <td>Oblique Single Whip<br>斜單鞭</td>
            <td></td><td>1</td><td>192</td>
        </tr>
        <tr>
            <td>58</td>
            <td>Wild Horse Shaking Mane (Right)<br>野馬分鬃(右)</td>
            <td>1</td><td>7</td><td>199</td>
        </tr>
        <tr>
            <td>59</td>
            <td>Wild Horse Shaking Mane (Left)<br>野馬分鬃(左)</td>
            <td>1</td><td>3</td><td>202</td>
        </tr>
        <tr>
            <td>60</td>
            <td>Wild Horse Shaking Mane (Right)<br>野馬分鬃(右)</td>
            <td>1</td><td>3</td><td>205</td>
        </tr>
        <tr style="font-weight: bold;">
            <td></td>
            <td style="text-align: right;">Total for Forms 35-60</td>
            <td>19</td><td>78</td><td></td>
        </tr>
        <tr style="font-weight: bold;">
            <td></td>
            <td style="text-align: right;">Total for Forms 1-60</td>
            <td>46</td><td>205</td><td></td>
        </tr>

        </tbody>
        <tbody id="advanced2">
        <tr>
            <td><b>ADVANCED(II)</b></td><td></td><td></td><td></td><td></td>
        </tr>
        <tr>
            <td>61</td>
            <td>Maiden Pushing Shuttle (Left)<br>玉女穿梭(左)</td>
            <td>1</td><td>9</td><td>214</td>
        </tr>
        <tr>
            <td>62</td>
            <td>Maiden Pushing Shuttle (Right)<br>玉女穿梭(右)</td>
            <td>1</td><td>6</td><td>220</td>
        </tr>
        <tr>
            <td>63</td>
            <td>Maiden Pushing Shuttle (Left)<br>玉女穿梭(左)</td>
            <td>1</td><td>9</td><td>229</td>
        </tr>
        <tr>
            <td>64</td>
            <td>Maiden Pushing Shuttle (Right)<br>玉女穿梭(右)</td>
            <td>1</td><td>6</td><td>235</td>
        </tr>
        <tr>
            <td>65</td>
            <td>Grasping Bird's Tail<br>攬雀尾</td>
            <td></td><td>8</td><td>243</td>
        </tr>
        <tr>
            <td>66</td>
            <td>Single Whip<br>單鞭</td>
            <td></td><td>1</td><td>244</td>
        </tr>
        <tr>
            <td>67</td>
            <td>Cloud Hand One<br>雲手一</td>
            <td></td><td>2</td><td>246</td>
        </tr>
        <tr>
            <td>68</td>
            <td>Cloud Hand Two<br>雲手二</td>
            <td></td><td>4</td><td>250</td>
        </tr>
        <tr>
            <td>69</td>
            <td>Cloud Hand Three<br>雲手三</td>
            <td></td><td>4</td><td>254</td>
        </tr>
        <tr>
            <td>70</td>
            <td>Single Whip<br>單鞭</td>
            <td></td><td>2</td><td>256</td>
        </tr>
        <tr>
            <td>71</td>
            <td>Downward Extended Squat<br>下勢</td>
            <td>1</td><td>2</td><td>258</td>
        </tr>
        <tr>
            <td>72</td>
            <td>Golden Cockerel On Left Leg<br>左金雞獨立</td>
            <td>1</td><td>2</td><td>260</td>
        </tr>
        <tr>
            <td>73</td>
            <td>Golden Cockerel On Right Leg<br>右金雞獨立</td>
            <td>1</td><td>1</td><td>261</td>
        </tr>
        <tr>
            <td>74</td>
            <td>Reversed Right Forward Step<br>左倒攆猴</td>
            <td></td><td>1</td><td>262</td>
        </tr>
        <tr>
            <td>75</td>
            <td>Reversed Left Forward Step<br>右倒攆猴</td>
            <td></td><td>2</td><td>264</td>
        </tr>
        <tr>
            <td>76</td>
            <td>Reversed Right Forward Step<br>左倒攆猴</td>
            <td></td><td>2</td><td>266</td>
        </tr>
        <tr>
            <td>77</td>
            <td>Oblique Arm Glide<br>斜飛勢</td>
            <td></td><td>3</td><td>269</td>
        </tr>
        <tr>
            <td>78</td>
            <td>Upward Arm Elevation<br>提手上勢</td>
            <td></td><td>4</td><td>273</td>
        </tr>
        <tr>
            <td>79</td>
            <td>White Crane Spreading Wing<br>白鶴亮翅</td>
            <td></td><td>4</td><td>277</td>
        </tr>
        <tr>
            <td>80</td>
            <td>Left Forward Step<br>摟膝抝步(左)</td>
            <td></td><td>3</td><td>280</td>
        </tr>
        <tr>
            <td>81</td>
            <td>Sea Bottom Plunge<br>海底針</td>
            <td></td><td>3</td><td>283</td>
        </tr>
        <tr>
            <td>82</td>
            <td>Fan Through Tunnel<br>扇通背</td>
            <td></td><td>3</td><td>286</td>
        </tr>
        <tr>
            <td>83</td>
            <td>Turning Over Punch<br>撇身捶</td>
            <td></td><td>2</td><td>288</td>
        </tr>
        <tr>
            <td>84</td>
            <td>Advancing Block Punch<br>上步搬瓓捶</td>
            <td></td><td>4</td><td>292</td>
        </tr>
        <tr>
            <td>85</td>
            <td>Grasping Bird's Tail Forward<br>上步攬雀尾</td>
            <td>1</td><td>7</td><td>299</td>
        </tr>
        <tr>
            <td>86</td>
            <td>Single Whip<br>單鞭</td>
            <td></td><td>1</td><td>300</td>
        </tr>
        <tr>
            <td>87</td>
            <td>Cloud Hand One<br>雲手一</td>
            <td>1</td><td>2</td><td>302</td>
        </tr>
        <tr>
            <td>88</td>
            <td>Cloud Hand Two<br>雲手二</td>
            <td>1</td><td>4</td><td>306</td>
        </tr>
        <tr>
            <td>89</td>
            <td>Cloud Hand Three<br>雲手三</td>
            <td></td><td>4</td><td>310</td>
        </tr>
        <tr>
            <td>90</td>
            <td>Single Whip<br>單鞭</td>
            <td></td><td>2</td><td>312</td>
        </tr>
        <tr>
            <td>91</td>
            <td>Face Palm Strike<br>近面掌</td>
            <td>1</td><td>3</td><td>315</td>
        </tr>
        <tr>
            <td>92</td>
            <td>Turn-Around Side Strike Kick<br>轉身十字擺蓮</td>
            <td>1</td><td>2</td><td>317</td>
        </tr>
        <tr>
            <td>93</td>
            <td>Right Forward Step<br>摟膝抝步(右)</td>
            <td>1</td><td>1</td><td>318</td>
        </tr>
        <tr>
            <td>94</td>
            <td>Advancing Angled Punch<br>摟膝指襠捶</td>
            <td>1</td><td>3</td><td>321</td>
        </tr>
        <tr>
            <td>95</td>
            <td>Grasping Bird's Tail Forward<br>上步攬雀尾</td>
            <td></td><td>7</td><td>328</td>
        </tr>
        <tr>
            <td>96</td>
            <td>Single Whip<br>單鞭</td>
            <td></td><td>1</td><td>329</td>
        </tr>
        <tr>
            <td>97</td>
            <td>Downward Extended Squat<br>下勢</td>
            <td></td><td>2</td><td>331</td>
        </tr>
        <tr>
            <td>98</td>
            <td>Step-Up Seven Stars<br>上步七星</td>
            <td>1</td><td>2</td><td>333</td>
        </tr>
        <tr>
            <td>99</td>
            <td>Retreating to Ride Tiger<br>退步跨虎</td>
            <td>1</td><td>1</td><td>334</td>
        </tr>
        <tr>
            <td>100</td>
            <td>Turn-Around Face Palm Strike<br>轉身迎面掌</td>
            <td>1</td><td>4</td><td>338</td>
        </tr>
        <tr>
            <td>101</td>
            <td>Turn-Around Double Side Strike Kick<br>轉身雙擺蓮</td>
            <td>1</td><td>2</td><td>340</td>
        </tr>
        <tr>
            <td>102</td>
            <td>Curved Double Tiger Punch<br>彎弓射虎</td>
            <td>1</td><td>3</td><td>343</td>
        </tr>
        <tr>
            <td>103</td>
            <td>Step-Up Face Palm Strike<br>上步迎面掌</td>
            <td>1</td><td>2</td><td>345</td>
        </tr>
        <tr>
            <td>104</td>
            <td>Turn-Around Over Punch<br>翻身撇身捶</td>
            <td></td><td>2</td><td>347</td>
        </tr>
        <tr>
            <td>105</td>
            <td>Step-Up Left Side Block<br>上步高探馬(左)</td>
            <td></td><td>1</td><td>348</td>
        </tr>
        <tr>
            <td>106</td>
            <td>Grasping Bird's Tail Forward<br>上步攬雀尾</td>
            <td></td><td>7</td><td>355</td>
        </tr>
        <tr>
            <td>107</td>
            <td>Single Whip<br>單鞭</td>
            <td></td><td>1</td><td>356</td>
        </tr>
        <tr>
            <td>108</td>
            <td>Closing Tai Chi<br>合太極</td>
            <td>1</td><td>4</td><td>360</td>
        </tr>
        <tr style="font-weight: bold;">
            <td></td>
            <td style="text-align: right;">Total for Forms 61-108</td>
            <td>18</td><td>155</td><td></td>
        </tr>
        <tr style="font-weight: bold;">
            <td></td>
            <td style="text-align: right;">Total for Forms 1-108</td>
            <td>64</td><td>360</td><td></td>
        </tr>
        </tbody>
    </table>
   </form:form>


<jsp:include page="includes/footer.jsp"/>
